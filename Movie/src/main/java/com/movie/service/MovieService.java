package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.movie.repository.MovieRepository;
import com.movie.repository.MovieSpecification;
import com.movie.dto.RequestDto;
import com.movie.dto.RequestPageDto;
import com.movie.dto.ResponseDto;
import com.movie.entity.Movie;
import com.movie.helper.DtoHelper;


@Service
public class MovieService {
	
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MovieSpecification movieSpecification;
	
	
	public Page<ResponseDto> getMoviesList(RequestPageDto request) {
		Page<ResponseDto> dtoPage = null;
        Page<Movie> moviePage = null;
        if(request.getPageNumber()>0 && request.getPageSize()>0) {
        	Pageable paging = PageRequest.of(request.getPageNumber()-1, request.getPageSize());
            moviePage = movieRepository.findAll(paging);
            if (moviePage != null && moviePage.getContent() != null) {
            	dtoPage = moviePage.map(DtoHelper::convertToResponse);}
        }      
        return dtoPage;
	}
	
	

	public Page<ResponseDto> getFilteredMoviesList(RequestDto request) {
		Page<ResponseDto> dtoPage = null;
        Page<Movie> moviePage = null;
        if(request.getPageNumber()>0 && request.getPageSize()>0) {
        	Pageable paging = PageRequest.of(request.getPageNumber()-1, request.getPageSize());
            moviePage = movieRepository.findAll(movieSpecification.getMovies(request), paging);
            if (moviePage != null && moviePage.getContent() != null) {
            	dtoPage = moviePage.map(DtoHelper::convertToResponse);}
        } 
        return dtoPage;
    }
	

}
