package com.movie.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.env.Environment;

import com.movie.config.step.JobCompletionListener;
import com.movie.config.step.MovieProcessor;
import com.movie.config.step.MovieWriter;
import com.movie.config.step.MovieReader;
import com.movie.dto.*;
import com.movie.entity.Movie;
import com.movie.repository.MovieRepository;




//Configure spring batch in other to persist movies
//the process 
@Configuration
public class JobConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	  
	@Autowired
	private MovieRepository movieRepository;
	
	
	
    @Bean
	ItemReader<ResultDto> movieReader(Environment env, RestTemplate restTemplate) {
    	return new MovieReader(env.getProperty("REST_API_URL_WITH_KEY"), restTemplate);
	    }
	
	 @Bean
	 ItemProcessor<ResultDto,Movie> processor() {
	      return new MovieProcessor();
	  }
	  
	 
	 @Bean
	 RepositoryItemWriter<Movie> movieRepositoryItemWriter(){

		 RepositoryItemWriter<Movie> repositoryItemWriter = new RepositoryItemWriter<>();
		 repositoryItemWriter.setRepository(movieRepository);
		 repositoryItemWriter.setMethodName("save");
		 
		 return repositoryItemWriter;
	 }
		 
	 
	 @Bean
	 public JobExecutionListener listener() {
	      return new JobCompletionListener();
	 }
	 
	 
	 @Bean
	 public Step step1(ItemReader<ResultDto> movieReader,
	                        ItemProcessor<ResultDto, Movie> moviesItemProcessor,
	                        RepositoryItemWriter<Movie> movieRepositoryItemWriter) throws Exception {
	 return stepBuilderFactory.get("step1")
	                .<ResultDto, Movie>chunk(10)//save 10 movies at the same time
	                .reader(movieReader)
	                .processor(moviesItemProcessor)
	                .writer(movieRepositoryItemWriter)
	                .allowStartIfComplete(true)
	                .build();
	    }
	 
	 @Bean
	 public Job job(Step step1) throws Exception {
	        
	 return jobBuilderFactory.get("job")
			 		.incrementer(new RunIdIncrementer())
			 		.flow(step1)
			 		.end()
	                .listener(listener())
	                .build();
	 }
	 

}
