package fr.nextoo.weatherforecast.service.api.dto;

public class CoordinatesDto {

	private String lon;
	private String lat;

	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}

	@Override
	public String toString() {
		return "CoordinatesDto [lon=" + lon + ", lat=" + lat + "]";
	}

}
