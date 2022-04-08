package com.movie.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import com.movie.dto.RequestDto;
import com.movie.entity.Movie;



@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("testdb")
@TestPropertySource(locations = "classpath:persistence-test.properties")
public class MovieRepositoryandSpecificationTest {
	
	@Autowired
	MovieRepository repository;
	
	@Autowired
	MovieSpecification specification;
	
	
	Page<Movie> page = null;
	RequestDto requestDto = new RequestDto();
	
	
	@BeforeEach
	void setup(){
		
		Movie movie= new Movie (1, false,"Nemo, an adventurous young clownfish, ", "2003-05-30","en", "Finding Nemo",  111.37,8);
		Movie movie2= new Movie (2, true,"Nemo, an adventurous young clownfish, ", "2003-05-30","en", "Finding Nemo",  111.37,8);
		Movie movie3= new Movie (3, false,"Demo, an adventurous young clownfish, ", "2003-05-30","en", "Finding Nemo",  111.37,8);
		Movie movie4= new Movie (4, false,"Nemo, an adventurous young clownfish, ", "2004-05-30","en", "Finding Nemo",  111.37,8);
		Movie movie5= new Movie (5, false,"Nemo, an adventurous young clownfish, ", "2003-05-30","es", "Looking Nemo",  111.37,8);
		Movie movie6= new Movie (6, false,"Nemo, an adventurous young clownfish, ", "2003-05-30","en", "Finding Nemo",  110.37,8);
		Movie movie7= new Movie (7, false,"Nemo, an adventurous young clownfish, ", "2003-05-30","en", "Finding Nemo",  111.37,7);
		
		
		repository.save(movie);
		repository.save(movie2);
		repository.save(movie3);
		repository.save(movie4);
		repository.save(movie5);
		repository.save(movie6);
		repository.save(movie7);
	}
	
	@Test 
	void TestFindAllWithSpecAndPaging() {	
		requestDto = new RequestDto(1,10,false,"Nemo", "2003","en", "Finding",  111.37,8);
		Pageable paging = PageRequest.of(requestDto.getPageNumber()-1, requestDto.getPageSize());
		page = repository.findAll(specification.getMovies(requestDto), paging);		
		assertEquals(page.getContent().size(),1);
	}
}
