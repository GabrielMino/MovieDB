package com.movie.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
	
	private Boolean adult;

	private String overview;
	 
	private String releaseDate;

	private String originalLanguage;

	private String title;
	
	private Double popularity;

	private Integer voteAverage;
	

}


