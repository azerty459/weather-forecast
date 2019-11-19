package com.nextoo.meteo.dto;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class NextooHumidityForecast {

	private String ville;
	private Integer humiditeActuelle;
	private Map<String, Double> humiditeMoyen;
	private List<NextooForecast> lePlusSec;

	public NextooHumidityForecast() {

	}

	public NextooHumidityForecast(String ville, Integer humiditeActuelle, Map<String, Double> humiditeMoyen,
			List<NextooForecast> lePluSec) {
		super();
		this.ville = ville;
		this.humiditeActuelle = humiditeActuelle;
		this.humiditeMoyen = humiditeMoyen;
		this.lePlusSec = lePluSec;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getHumiditeActuelle() {
		return humiditeActuelle;
	}

	public void setHumiditeActuelle(Integer humiditeActuelle) {
		this.humiditeActuelle = humiditeActuelle;
	}

	public Map<String, Double> getHumiditeMoyen() {
		return humiditeMoyen;
	}

	public void setHumiditeMoyen(Map<String, Double> humiditeMoyen) {
		this.humiditeMoyen = humiditeMoyen;
	}

	public List<NextooForecast> getLePlusSec() {
		return lePlusSec;
	}

	public void setLePlusSec(List<NextooForecast> lePluSec) {
		this.lePlusSec = lePluSec;
	}

	public static NextooHumidityForecastBuilder builder() {
		return new NextooHumidityForecastBuilder();
	}

	public static class NextooHumidityForecastBuilder {

		private NextooHumidityForecast forecast;

		public NextooHumidityForecastBuilder() {
			forecast = new NextooHumidityForecast();
		}

		public NextooHumidityForecast build() {
			return forecast;
		}

		public NextooHumidityForecastBuilder ville(String ville) {
			forecast.ville = ville;
			return this;
		}

		public NextooHumidityForecastBuilder humiditeActuelle(Integer humiditeActuelle) {
			forecast.humiditeActuelle = humiditeActuelle;
			return this;
		}

		public NextooHumidityForecastBuilder humiditeMoyen(Map<String, Double> humiditeMoyen) {
			forecast.humiditeMoyen = humiditeMoyen;
			return this;
		}

		public NextooHumidityForecastBuilder lePluSec(List<NextooForecast> lePluSec) {
			forecast.lePlusSec = lePluSec;
			return this;
		}
	}
}
