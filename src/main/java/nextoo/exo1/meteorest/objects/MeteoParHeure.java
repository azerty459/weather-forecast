package nextoo.exo1.meteorest.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author liam
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoParHeure {
	
	/**
	 * Represente le niveau d'humidite
	 */
	@JsonProperty("RH2m")
	private int humidity;

	/**
	 * @return the humidity
	 */
	public int getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
	
	
}
