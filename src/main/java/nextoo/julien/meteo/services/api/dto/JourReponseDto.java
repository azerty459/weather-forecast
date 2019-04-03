package nextoo.julien.meteo.services.api.dto;

public class JourReponseDto {
	
	private String jour;
	
	private String date;
	
	private double tmpMin;
	
	private double tmpMax;
	
	private String condition;

	public JourReponseDto() {
		super();
	}

	public JourReponseDto(String jour, String date, double tmpMin, double tmpMax, String condition) {
		super();
		this.jour = jour;
		this.date = date;
		this.tmpMin = tmpMin;
		this.tmpMax = tmpMax;
		this.condition = condition;
	}



	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	
	
}
