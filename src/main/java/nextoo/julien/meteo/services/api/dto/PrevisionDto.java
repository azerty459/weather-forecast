package nextoo.julien.meteo.services.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import nextoo.julien.meteo.controller.dto.JourReponseDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrevisionDto {
	
	@JsonProperty("day_long")
	private String jour;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("tmin")
	private double tmpMin;
	
	@JsonProperty("tmax")
	private double tmpMax;
	
	@JsonProperty("condition")
	private String condition;
	
	@JsonProperty("icon")
	private String icone;
	
	@JsonProperty("hourly_data")
	private PrevisionsParHeureDto previsionsParHeure;

	public PrevisionDto() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public double getTmpMin() {
		return tmpMin;
	}

	public void setTmpMin(double tmpMin) {
		this.tmpMin = tmpMin;
	}

	public double getTmpMax() {
		return tmpMax;
	}

	public void setTmpMax(double tmpMax) {
		this.tmpMax = tmpMax;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public PrevisionsParHeureDto getPrevisionsParHeure() {
		return previsionsParHeure;
	}

	public void setPrevisionsParHeure(PrevisionsParHeureDto previsionsParHeure) {
		this.previsionsParHeure = previsionsParHeure;
	}
	
	public JourReponseDto convertToJourReponseDto() {
		
		JourReponseDto jourReponse = new JourReponseDto();
		jourReponse.setCondition(this.condition);
		jourReponse.setDate(this.date);
		jourReponse.setJour(this.jour);
		jourReponse.setTmpMin(this.tmpMin);
		jourReponse.setTmpMax(this.tmpMax);
		jourReponse.setIcone(this.icone);
		
		return jourReponse;
		
	}
	
}
