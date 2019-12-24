package fr.ia.meteo.meteo.api.dto.prevision;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PrevisionDTO {

    private LocalDate date;

    @JsonProperty("tmin")
    private Integer tempMin;

    @JsonProperty("tmax")
    private Integer tempMax;

    @JsonProperty("condition")
    private String condition;

    @JsonProperty("hourly_data")
    private PrevisionHoraireListDTO previsionHoraireListDTO;

    @JsonSetter("date")
    public void setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale.FRANCE);
        this.date = LocalDate.parse(date,formatter);
    }

    @JsonGetter("date")
    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale.FRANCE);
        String dateString = date.format(formatter);
        return dateString;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getTempMin() {
        return tempMin;
    }

    public void setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
    }

    public Integer getTempMax() {
        return tempMax;
    }

    public void setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PrevisionHoraireListDTO getPrevisionHoraireListDTO() {
        return previsionHoraireListDTO;
    }

    public void setPrevisionHoraireListDTO(PrevisionHoraireListDTO previsionHoraireListDTO) {
        this.previsionHoraireListDTO = previsionHoraireListDTO;
    }


    @Override
    public String toString() {
        return "Prevision{" +
                "date=" + date +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", condition='" + condition + '\'' +
                ", previsionHoraireList=" + previsionHoraireListDTO +
                '}';
    }
}
