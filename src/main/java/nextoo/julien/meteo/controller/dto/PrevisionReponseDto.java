package nextoo.julien.meteo.controller.dto;

public class PrevisionReponseDto {
	
	private String jour;
	
	private String date;
	
	private double tmpMin;
	
	private double tmpMax;
	
	private String condition;
	
	private String icone;

	public PrevisionReponseDto() {
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

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}
	
	
	
	
	
}
