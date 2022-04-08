package com.movie.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	private Integer id;

    private Boolean adult;

    @Lob
    private String overview;

    private String releaseDate;

    private String originalLanguage;

    private String title;

    private Double popularity;

    private Integer voteAverage;

    
}