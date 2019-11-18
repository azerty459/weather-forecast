package com.nextoo.meteo.dto;

import java.util.List;

public class NextooForecastWrapper {

	private String ville;

	private NextooForecast actuellement;

	private List<NextooForecast> previsions;

	public NextooForecastWrapper() {
	}

	public NextooForecastWrapper(String ville, NextooForecast actuellement, List<NextooForecast> previsions) {
		super();
		this.ville = ville;
		this.actuellement = actuellement;
		this.previsions = previsions;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public NextooForecast getActuellement() {
		return actuellement;
	}

	public void setActuellement(NextooForecast actuellement) {
		this.actuellement = actuellement;
	}

	public List<NextooForecast> getPrevisions() {
		return previsions;
	}

	public void setPrevisions(List<NextooForecast> previsions) {
		this.previsions = previsions;
	}

	public static NextooForecastWrapperBuilder builder() {
		return new NextooForecastWrapperBuilder();
	}

	public static class NextooForecastWrapperBuilder {

		private NextooForecastWrapper wrapper;

		public NextooForecastWrapperBuilder() {
			wrapper = new NextooForecastWrapper();
		}

		public NextooForecastWrapper build() {
			return wrapper;
		}

		public NextooForecastWrapperBuilder ville(String ville) {
			wrapper.ville = ville;
			return this;
		}

		public NextooForecastWrapperBuilder actuellement(NextooForecast actuellement) {
			wrapper.actuellement = actuellement;
			return this;

		}

		public NextooForecastWrapperBuilder previsions(List<NextooForecast> previsions) {
			wrapper.previsions = previsions;
			return this;
		}

	}

}
