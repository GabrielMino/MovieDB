package com.movie;


import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableBatchProcessing
public class MovieApplication {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
    // Configure Cors only for get Methods
    @Bean
    public WebMvcConfigurer getCorsConfiguration(){
    	return new WebMvcConfigurer() {
    		@Override
    		public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/")
                            .allowedOrigins("*")
                            .allowedMethods("GET")
                            .allowedHeaders("*");
    		}       
    	};
    }
    
	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
		
	}
	


}
