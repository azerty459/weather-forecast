package com.nextoo.meteo.dto;

public class NextooForecast {

	private String dateEtHeure;

	private String temps;

	private Double temperature;

	private Double temperatureMinimum;

	private Double temperatureMaximum;

	private Double pressionAtmospherique;

	private Integer humidite;

	public NextooForecast() {

	}

	public NextooForecast(String dateEtHeure, String temps, Double temperature, Double temperatureMinimum,
			Double temperatureMaximum, Double pressionAtmospherique, Integer humidite) {
		super();
		this.dateEtHeure = dateEtHeure;
		this.temps = temps;
		this.temperature = temperature;
		this.temperatureMinimum = temperatureMinimum;
		this.temperatureMaximum = temperatureMaximum;
		this.pressionAtmospherique = pressionAtmospherique;
		this.humidite = humidite;
	}

	public String getDateEtHeure() {
		return dateEtHeure;
	}

	public void setDateEtHeure(String dateEtHeure) {
		this.dateEtHeure = dateEtHeure;
	}

	public String getTemps() {
		return temps;
	}

	public void setTemps(String temps) {
		this.temps = temps;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getTemperatureMinimum() {
		return temperatureMinimum;
	}

	public void setTemperatureMinimum(Double temperatureMinimum) {
		this.temperatureMinimum = temperatureMinimum;
	}

	public Double getTemperatureMaximum() {
		return temperatureMaximum;
	}

	public void setTemperatureMaximum(Double temperatureMaximum) {
		this.temperatureMaximum = temperatureMaximum;
	}

	public Double getPressionAtmospherique() {
		return pressionAtmospherique;
	}

	public void setPressionAtmospherique(Double pressionAtmospherique) {
		this.pressionAtmospherique = pressionAtmospherique;
	}

	public Integer getHumidite() {
		return humidite;
	}

	public void setHumidite(Integer humidite) {
		this.humidite = humidite;
	}

	public static NextooForecastBuilder builder() {
		return new NextooForecastBuilder();
	}

	public static class NextooForecastBuilder {

		private NextooForecast forecast;

		public NextooForecastBuilder() {
			forecast = new NextooForecast();
		}
		
		public NextooForecast build() {
			return forecast;
		}

		public NextooForecastBuilder dateEtHeure(String dateEtHeure) {
			forecast.dateEtHeure = dateEtHeure;
			return this;
		}

		public NextooForecastBuilder temps(String temps) {
			forecast.temps = temps;
			return this;
		}

		public NextooForecastBuilder temperature(Double temperature) {
			forecast.temperature = temperature;
			return this;
		}

		public NextooForecastBuilder temperatureMinimum(Double temperatureMinimum) {
			forecast.temperatureMinimum = temperatureMinimum;
			return this;
		}

		public NextooForecastBuilder temperatureMaximum(Double temperatureMaximum) {
			forecast.temperatureMaximum = temperatureMaximum;
			return this;
		}

		public NextooForecastBuilder pressionAtmospherique(Double pressionAtmospherique) {
			forecast.pressionAtmospherique = pressionAtmospherique;
			return this;
		}

		public NextooForecastBuilder humidite(Integer humidite) {
			forecast.humidite = humidite;
			return this;
		}

	}

}
