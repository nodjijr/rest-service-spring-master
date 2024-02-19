package com.desafioapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUDIOS")
public class StudioOrderWinns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	@Column(name = "NAME", length = 255, nullable = false)
	private String NAME;

	@Column(name = "FK_ID_MOVIE", nullable = false)
	private String FK_ID_MOVIE;

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public StudioOrderWinns() {
	}

}
