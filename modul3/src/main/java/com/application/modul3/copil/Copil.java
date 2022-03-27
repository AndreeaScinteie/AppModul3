package com.application.modul3.copil;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.application.modul3.jucarie.Jucarie;

@Entity
@Table(name = "copil", schema = "administration")
public class Copil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nume")
	private String nume;
	
	@Column(name = "varsta")
	private Integer varsta;
	
	
	@OneToMany(mappedBy = "copil", fetch = FetchType.LAZY,
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true)
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
