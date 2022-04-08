package com.movie.helper;

import java.text.ParseException;

import org.springframework.stereotype.Component;
import com.movie.dto.ResponseDto;
import com.movie.dto.ResultDto;
import com.movie.entity.Movie;



@Component
public class DtoHelper {
	//Date date;
	
    public Movie convertToMovie(ResultDto source) throws ParseException {
    	
    	/*
    	if (!(source.getReleaseDate()==null) && !source.getReleaseDate().isBlank()){
    		date=new SimpleDateFormat("yyyy-MM-dd").parse(source.getReleaseDate());
    		}else {date=null;}
    	*/
    	    
        Movie movie = new Movie(source.getId(), source.getAdult(),
                source.getOverview(), source.getReleaseDate() ,
                source.getOriginalLanguage(), source.getTitle(),
                source.getPopularity(), source.getVoteAverage());;
		return movie;	
		
    }
    
    public static ResponseDto convertToResponse(Movie source) {
    	    
       ResponseDto response = new ResponseDto(source.getAdult(),
               source.getOverview(), source.getReleaseDate() ,
               source.getOriginalLanguage(), source.getTitle(),
               source.getPopularity(), source.getVoteAverage());
		return response;	
		
    }
    
	
}
