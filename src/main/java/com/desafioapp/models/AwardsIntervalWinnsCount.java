package com.desafioapp.models;


public class AwardsIntervalWinnsCount {
	String yearm;
	Integer wins;

	public AwardsIntervalWinnsCount() {
		super();
	}
	public AwardsIntervalWinnsCount(String yearm, Integer wins) {
		super();
		this.setYearm(yearm);
		this.setWins(wins);
	}


	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public String getYearm() {
		return yearm;
	}

	public void setYearm(String yearm) {
		this.yearm = yearm;
	}	

}
