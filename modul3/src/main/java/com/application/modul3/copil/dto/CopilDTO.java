package com.application.modul3.copil.dto;

import java.util.List;


import com.application.modul3.jucarie.Jucarie;

public class CopilDTO {

private Integer id;
	
	private String nume;

	private Integer varsta;

	private List<Jucarie> listaJucarii;

	
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

	public Integer getVarsta() {
		return varsta;
	}

	public void setVarsta(Integer varsta) {
		this.varsta = varsta;
	}

	public List<Jucarie> getListaJucarii() {
		return listaJucarii;
	}

	public void setListaJucarii(List<Jucarie> listaJucarii) {
		this.listaJucarii = listaJucarii;
	}
	
	
}
