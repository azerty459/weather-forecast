package com.nextoo.asenoussi.ex1.api.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CityInfo {
	
	@JsonProperty("name")
	private String nomLocale;
	
	@JsonProperty("latitude")
	private String latitude;
	
	@JsonProperty("longitude")
	private String longitude;
	
	@JsonProperty("sunrise")
	private String leveSoleil;
	
	@JsonProperty("sunset")
	private String coucheSoleil;
	
	public String getNomLocalite() {return nomLocale;}

	public void setNomLocalite(String nomLocalite) {this.nomLocale = nomLocalite;}

	public String getLatitude() {return latitude;}

	public void setLatitude(String latitude) {this.latitude = latitude;}

	public String getLongitude() {return longitude;}

	public void setLongitude(String longitude) {this.longitude = longitude;}

	public String getLeveSoleil() {return leveSoleil;}

	public void setLeveSoleil(String leveSoleil) {this.leveSoleil = leveSoleil;}

	public String getCoucheSoleil() {return coucheSoleil;}

	public void setCoucheSoleil(String coucheSoleil) {this.coucheSoleil = coucheSoleil;}
	
	
}

