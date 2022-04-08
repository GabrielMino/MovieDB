package com.movie.config.step;


import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.movie.dto.PagesDto;
import com.movie.dto.ResultDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieReader implements ItemReader<ResultDto> {

	    private static final Logger LOGGER = LoggerFactory.getLogger(MovieReader.class);
	    //Define in properties
	    private final String apiUrl;
	    private final RestTemplate restTemplate;

	    private int nextIndex;
	    private List<ResultDto> resultData;
	    
	    private int numPages;
	    private int page;

	    public MovieReader(String apiUrl, RestTemplate restTemplate) {
	        this.apiUrl = apiUrl;
	        this.restTemplate = restTemplate;
	        nextIndex = 0;
	        page =1;
	    }

	    @Override
	    public ResultDto read() throws Exception {
	        LOGGER.info("Reading the information of the next movie");
	        
	               
	        if (resultDataIsNotInitialized()) {
	        	//initialize and get the first page
	        	resultData = fetchResultDataFromAPI(page);
	        		
	        }
	        
	        ResultDto nextResult = null;
	        if (nextIndex < resultData.size()) {
	            nextResult = resultData.get(nextIndex);
	            nextIndex++;
	        }
	        else {
	        	//The api only permits to get 500 pages from the popular movies.
	        	if (page<500) {
	        		nextIndex=0;
	        		//starts in page 2
	        		resultData = fetchResultDataFromAPI(++page);
	        		nextResult = resultData.get(nextIndex);
	        	}
	        	else {
	            nextIndex = 0;
	            resultData = null;   
	        	}
	        }
	        LOGGER.info("Found movie: {}", nextResult);
	        return nextResult;
	    }
	    
	    private boolean resultDataIsNotInitialized() {
	        return this.resultData == null;
	    }
	    //method to get the data from the api
	    private List<ResultDto> fetchResultDataFromAPI(int page) {
	        LOGGER.debug("Fetching url data from an external API by using the url: {}", apiUrl);
	        ResponseEntity<PagesDto> response = restTemplate.getForEntity(apiUrl+page, PagesDto.class);
	        ResultDto[] resultData = response.getBody().getResults();
	        
	        LOGGER.debug("Found {} students", resultData.length);

	        return Arrays.asList(resultData);
	    }
	}	
	




