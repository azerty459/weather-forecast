package nextoo.julien.meteo.services.api.dto;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoDto {

	@JsonProperty("city_info")
	private VilleInfoDto villeInfo;

	@JsonProperty("current_condition")
	private ConditionCouranteDto conditionCourante;

	@JsonProperty("fcst_day_0")
	private PrevisionDto prevision_j0;

	@JsonProperty("fcst_day_1")
	private PrevisionDto prevision_j1;

	@JsonProperty("fcst_day_2")
	private PrevisionDto prevision_j2;

	@JsonProperty("fcst_day_3")
	private PrevisionDto prevision_j3;

	@JsonProperty("fcst_day_4")
	private PrevisionDto prevision_j4;

	public MeteoDto() {
		super();
	}

	public VilleInfoDto getVilleInfo() {
		return villeInfo;
	}

	public void setVilleInfo(VilleInfoDto villeInfo) {
		this.villeInfo = villeInfo;
	}

	public PrevisionDto getPrevision_j0() {
		return prevision_j0;
	}

	public void setPrevision_j0(PrevisionDto prevision_j0) {
		this.prevision_j0 = prevision_j0;
	}

	public PrevisionDto getPrevision_j1() {
		return prevision_j1;
	}

	public void setPrevision_j1(PrevisionDto prevision_j1) {
		this.prevision_j1 = prevision_j1;
	}

	public PrevisionDto getPrevision_j2() {
		return prevision_j2;
	}

	public void setPrevision_j2(PrevisionDto prevision_j2) {
		this.prevision_j2 = prevision_j2;
	}

	public PrevisionDto getPrevision_j3() {
		return prevision_j3;
	}

	public void setPrevision_j3(PrevisionDto prevision_j3) {
		this.prevision_j3 = prevision_j3;
	}

	public PrevisionDto getPrevision_j4() {
		return prevision_j4;
	}

	public void setPrevision_j4(PrevisionDto prevision_j4) {
		this.prevision_j4 = prevision_j4;
	}

	public ConditionCouranteDto getConditionCourante() {
		return conditionCourante;
	}

	public void setConditionCourante(ConditionCouranteDto conditionCourante) {
		this.conditionCourante = conditionCourante;
	}

	@JsonIgnore
	public Collection<PrevisionDto> getPrevisionsList() {
		Collection<PrevisionDto> previsions = new ArrayList<PrevisionDto>();

		previsions.add(this.getPrevision_j0());
		previsions.add(this.getPrevision_j1());
		previsions.add(this.getPrevision_j2());
		previsions.add(this.getPrevision_j3());
		previsions.add(this.getPrevision_j4());

		return previsions;

	}

}
