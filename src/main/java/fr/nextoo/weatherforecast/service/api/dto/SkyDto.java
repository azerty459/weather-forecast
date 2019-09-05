package fr.nextoo.weatherforecast.service.api.dto;

public class SkyDto {

	private String main;
	private String description;

	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SkyDto [main=" + main + ", description=" + description + "]";
	}

}
