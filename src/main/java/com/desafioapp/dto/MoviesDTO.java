package com.desafioapp.dto;

import java.util.List;

import com.desafioapp.entity.Movie;
import com.desafioapp.models.ReturnStatus;

import lombok.Data;

@Data
public class MoviesDTO {
	
	private List<Movie> movies;
	private ReturnStatus returnStatus;
	

	public MoviesDTO(String year) {
		returnStatus = new ReturnStatus("00200", "/movies/"+year);
	}
	
}
