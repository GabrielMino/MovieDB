package com.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagesDto {
	
	private int page;
	private ResultDto[] results;
	private int total_result;
	private int total_pages;
	
}
