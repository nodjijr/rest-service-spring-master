package com.desafioapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity(name = "AWARDSINTERVAL")
@Data
public class AwardsInterval {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
  
	//@Transient
	@Column(name = "producer", length = 255)
	private String producer;
	
	@Column(name = "interval")
	private int interval;
	
	@Transient
	private int previousWin;
	
	@Transient
	private int followingWin;
	
	@Transient
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	
	public int getPreviousWin() {
		return previousWin;
	}
	public void setPreviousWin(int previousWin) {
		this.previousWin = previousWin;
	}
	public int getFollowingWin() {
		return followingWin;
	}
	public void setFollowingWin(int followingWin) {
		this.followingWin = followingWin;
	}
	
	public AwardsInterval(String producer, int interval, int previousWin, int followingWin) {
		super();
		this.producer = producer;
		this.interval = interval;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
	}
	
}
