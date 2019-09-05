package fr.nextoo.weatherforecast.bean;

import java.util.Date;
import java.util.List;

public class WeatherBean {

	private List<SkyBean> sky;
	private AtmosphereBean atmosphere;
	private WindBean wind;
	private Date dateTime;

	public List<SkyBean> getSky() {
		return sky;
	}

	public void setSky(List<SkyBean> sky) {
		this.sky = sky;
	}

	public AtmosphereBean getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(AtmosphereBean atmosphere) {
		this.atmosphere = atmosphere;
	}

	public WindBean getWind() {
		return wind;
	}

	public void setWind(WindBean wind) {
		this.wind = wind;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "WeatherBean [sky=" + sky + ", atmosphere=" + atmosphere + ", wind=" + wind + ", dateTime=" + dateTime
				+ "]";
	}

}