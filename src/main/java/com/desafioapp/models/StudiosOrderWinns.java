package com.desafioapp.models;

import lombok.Data;

@Data
public class StudiosOrderWinns {
	private String name;
	private int winCount;

	public StudiosOrderWinns(String name, int wincount) {
		this.setName(name);
		this.setWinCount(wincount);
	}	
	
}
