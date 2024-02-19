package com.desafioapp.dto;

import java.util.List;

import com.desafioapp.models.ReturnStatus;
import com.desafioapp.models.StudiosOrderWinns;

import lombok.Data;

@Data
public class StudiosOrderWinnsDTO {
	private List<StudiosOrderWinns> studios;	
	private ReturnStatus returnStatus;
	
	public StudiosOrderWinnsDTO() {
		this.returnStatus = new ReturnStatus("00200", "/movies/studios");
	}
	
}
