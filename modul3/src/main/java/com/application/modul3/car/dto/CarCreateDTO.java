package com.application.modul3.car.dto;

import java.time.LocalDate;


public class CarCreateDTO {

	private String mark;
	private String model;
	private LocalDate productionDate;
	private Integer power;
	private Integer personId;
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(LocalDate productionDate) {
		this.productionDate = productionDate;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	
	
	
}
