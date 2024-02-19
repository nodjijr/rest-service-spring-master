package com.desafioapp.dto;

import java.util.List;

import com.desafioapp.entity.AwardsInterval;
import com.desafioapp.models.ReturnStatus;

import lombok.Data;

@Data
public class AwardsIntervalDTO {
	private List<AwardsInterval> min;
	private List<AwardsInterval> max;
	private ReturnStatus returnStatus;
	
	public AwardsIntervalDTO() {
		super();
		this.returnStatus = new ReturnStatus("00200", "/movies/awardsinterval");
	}
	
}
