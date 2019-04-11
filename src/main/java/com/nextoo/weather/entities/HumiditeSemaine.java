package com.nextoo.weather.entities;

import java.util.Collection;

public class HumiditeSemaine {
	private double humiditeActuelle;
	
	private Collection<Double> humiditeMoyenneJourSemaine;

	public double getHumiditeActuelle() {
		return humiditeActuelle;
	}

	public void setHumiditeActuelle(double humiditeActuelle) {
		this.humiditeActuelle = humiditeActuelle;
	}

	public Collection<Double> getHumiditeMoyenneJourSemaine() {
		return humiditeMoyenneJourSemaine;
	}

	public void setHumiditeMoyenneJourSemaine(Collection<Double> humiditeMoyenneJourSemaine) {
		this.humiditeMoyenneJourSemaine = humiditeMoyenneJourSemaine;
	}
	
	
}
