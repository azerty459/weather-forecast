package com.nextoo.weather.entities;

import java.util.ArrayList;
import java.util.Collection;

public class Meteo {
	
	private VilleInfos villeInfos;
	private ConditionActuel conditionActuel;
	private Collection<Prevision> previsionSemaine;
	
	public Meteo() {
		super();
	}
	
	public Meteo(PrevisionResponseDTO prevDTO) {
		super();
		this.villeInfos = prevDTO.getVilleInfos();
		this.conditionActuel = prevDTO.getConditionActuel();
		previsionSemaine= new ArrayList<Prevision>();
		previsionSemaine.add(prevDTO.getPrevisionJour0());
		previsionSemaine.add(prevDTO.getPrevisionJour1());
		previsionSemaine.add(prevDTO.getPrevisionJour2());
		previsionSemaine.add(prevDTO.getPrevisionJour3());
		previsionSemaine.add(prevDTO.getPrevisionJour4());
	}

	public VilleInfos getVilleInfos() {
		return villeInfos;
	}

	public void setVilleInfos(VilleInfos villeInfos) {
		this.villeInfos = villeInfos;
	}

	public ConditionActuel getConditionActuel() {
		return conditionActuel;
	}

	public void setConditionActuel(ConditionActuel conditionActuel) {
		this.conditionActuel = conditionActuel;
	}

	public Collection<Prevision> getPrevisionSemaine() {
		return previsionSemaine;
	}

	public void setPrevisionSemaine(Collection<Prevision> previsionSemaine) {
		this.previsionSemaine = previsionSemaine;
	}
	
	
		
}
