package com.movie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.movie.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Integer> ,  JpaSpecificationExecutor<Movie>{
	

    public Page<Movie> findAll(Specification<Movie> spec, Pageable pageable);

	  
	
}
