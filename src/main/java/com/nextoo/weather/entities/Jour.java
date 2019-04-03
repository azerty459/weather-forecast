package com.nextoo.weather.entities;

public class Jour {
	
	private VilleInfos villeInfos;
	
	private Prevision jourLePlusChaud;

	public VilleInfos getVilleInfos() {
		return villeInfos;
	}

	public void setVilleInfos(VilleInfos villeInfos) {
		this.villeInfos = villeInfos;
	}

	public Prevision getJourLePlusChaud() {
		return jourLePlusChaud;
	}

	public void setJourLePlusChaud(Prevision jourLePlusChaud) {
		this.jourLePlusChaud = jourLePlusChaud;
	}
	
	
}
