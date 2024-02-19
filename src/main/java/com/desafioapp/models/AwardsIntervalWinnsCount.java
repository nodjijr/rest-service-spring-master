package com.desafioapp.models;

import lombok.Data;

@Data
public class AwardsIntervalWinnsCount {
	private String year;
	private int winnerCount;

	public AwardsIntervalWinnsCount(String year, int wincount) {
		super();
		this.year = year;
		this.winnerCount = wincount;
	}	

}
