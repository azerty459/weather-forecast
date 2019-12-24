package fr.ia.meteo.meteo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ville {

    @JsonProperty("name")
    private String nom;

    @JsonProperty("latitude")
    private Float latitude;

    @JsonProperty("longitude")
    private Float longitude;

    @JsonProperty("elevation")
    private Integer altitude;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }


    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }



}
