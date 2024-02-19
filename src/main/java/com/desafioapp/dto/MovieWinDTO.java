package com.desafioapp.dto;

import java.util.List;

import com.desafioapp.models.AwardsIntervalWinnsCount;
import com.desafioapp.models.ReturnStatus;

import lombok.Data;

@Data
public class MovieWinDTO {
	
	private List<AwardsIntervalWinnsCount> years;	
	private ReturnStatus returnStatus;
	
	public MovieWinDTO() {
		this.returnStatus = new ReturnStatus("00200", "/movies/yearsmoreonewinners");
	}

	
}
