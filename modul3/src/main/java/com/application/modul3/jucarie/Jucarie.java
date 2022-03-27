package com.application.modul3.jucarie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.application.modul3.copil.Copil;

@Entity
@Table(name = "jucarie", schema = "administration")
public class Jucarie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nume")
	private String nume;
	
	@Column(name = "tip")
	private String tip;
	
	@Column(name = "pret")
	private double pret;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "copil_id", updatable = false)
	private Copil copil;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public Copil getCopil() {
		return copil;
	}

	public void setCopil(Copil copil) {
		this.copil = copil;
	}

	
	
}
