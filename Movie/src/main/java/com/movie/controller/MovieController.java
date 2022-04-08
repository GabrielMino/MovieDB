package com.movie.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.RequestDto;
import com.movie.dto.RequestPageDto;
import com.movie.dto.ResponseDto;
import com.movie.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping(value="/movies/")
	private ResponseEntity<Page<ResponseDto>> getMovies(@RequestBody RequestPageDto requestDto ){
        return new ResponseEntity<>(movieService.getMoviesList(requestDto),
                HttpStatus.OK);
	}
	
	@GetMapping(value="/filtered/")
    public ResponseEntity<Page<ResponseDto>> getFilteredMovies(@RequestBody RequestDto requestDto ){
        return new ResponseEntity<>(movieService.getFilteredMoviesList(requestDto),
                HttpStatus.OK);
	}	
	
	
}

