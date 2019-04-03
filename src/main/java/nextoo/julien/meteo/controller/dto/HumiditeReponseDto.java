package nextoo.julien.meteo.controller.dto;

public class HumiditeReponseDto {
	
	private double humiditeCourante;
	
	private double humiditeMoyenneSemaine;
	
	private String indicateurHumidite;

	public HumiditeReponseDto() {
		super();
	}

	public double getHumiditeCourante() {
		return humiditeCourante;
	}

	public void setHumiditeCourante(double humiditeCourante) {
		this.humiditeCourante = humiditeCourante;
	}

	public double getHumiditeMoyenneSemaine() {
		return humiditeMoyenneSemaine;
	}

	public void setHumiditeMoyenneSemaine(double humiditeMoyenneSemaine) {
		this.humiditeMoyenneSemaine = humiditeMoyenneSemaine;
	}

	public String getIndicateurHumidite() {
		return indicateurHumidite;
	}

	public void setIndicateurHumidite() {
		if(this.humiditeCourante >= this.humiditeMoyenneSemaine) {
			this.indicateurHumidite = "Temps plus humide aujourd'hui";
		} else {
			this.indicateurHumidite = "Temps plus sec aujourd'hui";
		}
	}
	
	

}
