package com.movie.config.step;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.movie.dto.ResultDto;
import com.movie.entity.Movie;
import com.movie.helper.DtoHelper;

public class MovieProcessor implements ItemProcessor<ResultDto,Movie>{
	
	@Autowired
    private DtoHelper resultToMovie;
	
	@Override
	public Movie process(ResultDto item) throws Exception {
		
		Movie movie = resultToMovie.convertToMovie(item);
		
		return movie;
	}

}
