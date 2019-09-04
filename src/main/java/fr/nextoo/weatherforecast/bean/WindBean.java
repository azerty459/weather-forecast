package fr.nextoo.weatherforecast.bean;

public class WindBean {

	private double windSpeed;
	private double windDegrees;

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getWindDegrees() {
		return windDegrees;
	}

	public void setWindDegrees(double windDegrees) {
		this.windDegrees = windDegrees;
	}

	@Override
	public String toString() {
		return "WindBean [windSpeed=" + windSpeed + ", windDegrees=" + windDegrees + "]";
	}

}
