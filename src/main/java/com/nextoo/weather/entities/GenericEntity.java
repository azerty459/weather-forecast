package com.nextoo.weather.entities;

public class GenericEntity {
	Long id;
	String value;
	
	public Long getId() {
		return this.id;
	}

	public GenericEntity(Long id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	
}
