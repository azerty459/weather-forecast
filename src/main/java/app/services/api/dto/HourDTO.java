package app.services.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HourDTO {

    private Double RH2m;

    private Double APCPsfc;

    public Double getRH2m() {
        return RH2m;
    }

    public void setRH2m(Double rH2m) {
        RH2m = rH2m;
    }

    public Double getAPCPsfc() {
        return APCPsfc;
    }

    public void setAPCPsfc(Double APCPsfc) {
        this.APCPsfc = APCPsfc;
    }
}
