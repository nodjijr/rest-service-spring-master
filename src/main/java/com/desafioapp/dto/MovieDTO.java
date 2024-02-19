package com.desafioapp.dto;

import java.util.List;

import com.desafioapp.entity.Movie;
import com.desafioapp.models.ReturnStatus;

import lombok.Data;

@Data
public class MovieDTO {
	
	private List<Movie> movies;
	private ReturnStatus returnStatus;
	
	public MovieDTO(String year) {
		returnStatus = new ReturnStatus("00200", "/movies/"+year);
	}
	
}
