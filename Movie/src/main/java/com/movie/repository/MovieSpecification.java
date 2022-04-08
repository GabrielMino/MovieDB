package com.movie.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.movie.dto.RequestDto;
import com.movie.entity.Movie;

import javax.persistence.criteria.Predicate;

@Component
public class MovieSpecification {
	

    public Specification<Movie> getMovies(RequestDto request) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            // look for the year in release date
            if (request.getYear() != null && !request.getYear().isEmpty()) {
            	
                predicates.add(criteriaBuilder.like(root.get("releaseDate"),
                		"%" + request.getYear() + "%"));   		          	
            }
            
            //look for word in the title
            if (request.getTitle() != null && !request.getTitle().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),
                        "%" + request.getTitle().toLowerCase() + "%"));
            }
            
            //look for word in overview
            if (request.getOverview() != null && !request.getOverview().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("overview")),
                        "%" + request.getOverview().toLowerCase() + "%"));
            }
            
            //check if it is and adult movie
            if (request.getAdult() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("adult"), request.getAdult()));
            }
            
            //popularity looks for a value greater than
            if (request.getPopularity() != null ) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("popularity"), request.getPopularity()));
            }
            
            //voteAverage looks for a value greater than
            if (request.getVoteAverage() != null ) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("voteAverage"), request.getVoteAverage()));
            }
            
            query.orderBy(criteriaBuilder.desc(root.get("title")));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}


