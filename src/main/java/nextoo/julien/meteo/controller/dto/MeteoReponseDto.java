package nextoo.julien.meteo.controller.dto;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MeteoReponseDto {

	private VilleInfoReponseDto villeInfo;

	private ConditionCouranteReponseDto conditionCourante;

	private PrevisionReponseDto prevision_j0;

	private PrevisionReponseDto prevision_j1;

	private PrevisionReponseDto prevision_j2;

	private PrevisionReponseDto prevision_j3;

	private PrevisionReponseDto prevision_j4;

	public MeteoReponseDto() {
		super();
	}

	public VilleInfoReponseDto getVilleInfo() {
		return villeInfo;
	}

	public void setVilleInfo(VilleInfoReponseDto villeInfo) {
		this.villeInfo = villeInfo;
	}

	public PrevisionReponseDto getPrevision_j0() {
		return prevision_j0;
	}

	public void setPrevision_j0(PrevisionReponseDto prevision_j0) {
		this.prevision_j0 = prevision_j0;
	}

	public PrevisionReponseDto getPrevision_j1() {
		return prevision_j1;
	}

	public void setPrevision_j1(PrevisionReponseDto prevision_j1) {
		this.prevision_j1 = prevision_j1;
	}

	public PrevisionReponseDto getPrevision_j2() {
		return prevision_j2;
	}

	public void setPrevision_j2(PrevisionReponseDto prevision_j2) {
		this.prevision_j2 = prevision_j2;
	}

	public PrevisionReponseDto getPrevision_j3() {
		return prevision_j3;
	}

	public void setPrevision_j3(PrevisionReponseDto prevision_j3) {
		this.prevision_j3 = prevision_j3;
	}

	public PrevisionReponseDto getPrevision_j4() {
		return prevision_j4;
	}

	public void setPrevision_j4(PrevisionReponseDto prevision_j4) {
		this.prevision_j4 = prevision_j4;
	}

	public ConditionCouranteReponseDto getConditionCourante() {
		return conditionCourante;
	}

	public void setConditionCourante(ConditionCouranteReponseDto conditionCourante) {
		this.conditionCourante = conditionCourante;
	}

	@JsonIgnore
	public Collection<PrevisionReponseDto> getPrevisionsList() {
		Collection<PrevisionReponseDto> previsions = new ArrayList<PrevisionReponseDto>();

		previsions.add(this.getPrevision_j0());
		previsions.add(this.getPrevision_j1());
		previsions.add(this.getPrevision_j2());
		previsions.add(this.getPrevision_j3());
		previsions.add(this.getPrevision_j4());

		return previsions;

	}

}
