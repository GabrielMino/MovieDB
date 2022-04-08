package com.movie.config.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.movie.repository.MovieRepository;



public class JobCompletionListener implements JobExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobCompletionListener.class);

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        LOGGER.info("RUNNING JobCompletion Check.");

        long cnt = movieRepository.count();

        LOGGER.info("Total Movies Saved: {}", cnt);



     }
}