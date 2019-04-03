package nextoo.julien.meteo.controller.dto;

public class MeteoReponseDto {

	private VilleInfoReponseDto villeInfo;

	private ConditionCouranteReponseDto conditionCourante;

	private JourReponseDto prevision_j0;

	private JourReponseDto prevision_j1;

	private JourReponseDto prevision_j2;

	private JourReponseDto prevision_j3;

	private JourReponseDto prevision_j4;

	public MeteoReponseDto() {
		super();
	}

	public VilleInfoReponseDto getVilleInfo() {
		return villeInfo;
	}

	public void setVilleInfo(VilleInfoReponseDto villeInfo) {
		this.villeInfo = villeInfo;
	}

	public JourReponseDto getPrevision_j0() {
		return prevision_j0;
	}

	public void setPrevision_j0(JourReponseDto prevision_j0) {
		this.prevision_j0 = prevision_j0;
	}

	public JourReponseDto getPrevision_j1() {
		return prevision_j1;
	}

	public void setPrevision_j1(JourReponseDto prevision_j1) {
		this.prevision_j1 = prevision_j1;
	}

	public JourReponseDto getPrevision_j2() {
		return prevision_j2;
	}

	public void setPrevision_j2(JourReponseDto prevision_j2) {
		this.prevision_j2 = prevision_j2;
	}

	public JourReponseDto getPrevision_j3() {
		return prevision_j3;
	}

	public void setPrevision_j3(JourReponseDto prevision_j3) {
		this.prevision_j3 = prevision_j3;
	}

	public JourReponseDto getPrevision_j4() {
		return prevision_j4;
	}

	public void setPrevision_j4(JourReponseDto prevision_j4) {
		this.prevision_j4 = prevision_j4;
	}

	public ConditionCouranteReponseDto getConditionCourante() {
		return conditionCourante;
	}

	public void setConditionCourante(ConditionCouranteReponseDto conditionCourante) {
		this.conditionCourante = conditionCourante;
	}

}
