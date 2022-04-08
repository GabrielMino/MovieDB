package com.movie.config.step;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.movie.entity.Movie;



public class MovieWriter implements ItemWriter<List<Movie>> {

	@Override
	public void write(List<? extends List<Movie>> items) throws Exception {
		
	}
    }

