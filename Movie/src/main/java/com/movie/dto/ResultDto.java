package com.movie.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
	
	
	@JsonPropertyOrder({
		"id",
	    "poster_path",
	    "adult",
	    "overview",
	    "release_date",
	    //"genre_ids",
	    "original_title",
	    "original_language",
	    "title",
	    "backdrop_path",
	    "popularity",
	    "vote_count",
	    "video",
	    "vote_average"
	})
	
	@JsonProperty("id")
    private Integer id;
	@JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("adult")
    private Boolean adult;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("original_title")
    private String originalTitle;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("title")
    private String title;
	@JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("popularity")
    private Double popularity;
    @JsonProperty("vote_count")
    private Integer voteCount;
    @JsonProperty("video")
    private Boolean video;
    @JsonProperty("vote_average")
    private Integer voteAverage;
    
   

}
