package com.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
	
	private int pageNumber = 1;
	
    private int pageSize = 10;
	
    private Boolean adult;
    
    private String overview;

    private String year;

    private String originalLanguage;

    private String title;

    private Double popularity;

    private Integer voteAverage;
    

}
