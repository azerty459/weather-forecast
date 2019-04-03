package nextoo.exo1.meteorest.objects;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liam
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TraitementJson {
	@JsonProperty("city_info")
	Ville ville;
	
	@JsonProperty("current_condition")
	Meteo current;
	
	@JsonProperty("fcst_day_0")
	Meteo j0;
	
	@JsonProperty("fcst_day_1")
	Meteo j1;
	
	@JsonProperty("fcst_day_2")
	Meteo j2;
	
	@JsonProperty("fcst_day_3")
	Meteo j3;

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
	public Meteo getCurrent() {
		return current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(Meteo current) {
		this.current = current;
	}

	/**
	 * @return the j0
	 */
	public ArrayList<Meteo> getPrevisions() {
		ArrayList<Meteo> previsions = new ArrayList<Meteo>();
		previsions.add(j0);
		previsions.add(j1);
		previsions.add(j2);
		previsions.add(j3);
		return previsions;
	}
	
	
	
}
