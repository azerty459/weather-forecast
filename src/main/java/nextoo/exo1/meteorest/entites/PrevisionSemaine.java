package nextoo.exo1.meteorest.entites;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liam
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrevisionSemaine {
	@JsonProperty("city_info")
	Ville ville;
	
	@JsonProperty("current_condition")
	PrevisionJour current;
	
	@JsonProperty("fcst_day_0")
	PrevisionJour j0;
	
	@JsonProperty("fcst_day_1")
	PrevisionJour j1;
	
	@JsonProperty("fcst_day_2")
	PrevisionJour j2;
	
	@JsonProperty("fcst_day_3")
	PrevisionJour j3;

	/**
	 * @return the ville
	 */
	public Ville getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(Ville ville) {
		this.ville = ville;
	}

	/**
	 * @return the current
	 */
	public PrevisionJour getCurrent() {
		return current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(PrevisionJour current) {
		this.current = current;
	}

	/**
	 * @return the j0
	 */
	public ArrayList<PrevisionJour> getPrevisions() {
		ArrayList<PrevisionJour> previsions = new ArrayList<PrevisionJour>();
		previsions.add(j0);
		previsions.add(j1);
		previsions.add(j2);
		previsions.add(j3);
		return previsions;
	}
	
	
	
}
