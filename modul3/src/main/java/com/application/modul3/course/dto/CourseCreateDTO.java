package com.application.modul3.course.dto;

public class CourseCreateDTO {

	private String name;
	private Integer durationInHours;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(Integer durationInHours) {
		this.durationInHours = durationInHours;
	}
}
