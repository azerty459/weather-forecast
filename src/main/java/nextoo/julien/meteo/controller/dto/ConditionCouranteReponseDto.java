package nextoo.julien.meteo.controller.dto;

public class ConditionCouranteReponseDto {

	private double humidite;

	private double temperatureActuelle;

	public ConditionCouranteReponseDto() {
		super();
	}

	public double getHumidite() {
		return humidite;
	}

	public void setHumidite(double humidite) {
		this.humidite = humidite;
	}

	public double getTemperatureActuelle() {
		return temperatureActuelle;
	}

	public void setTemperatureActuelle(double temperatureActuelle) {
		this.temperatureActuelle = temperatureActuelle;
	}

}
