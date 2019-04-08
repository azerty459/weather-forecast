package app.services.api.dto.transformer;

import app.services.api.dto.HourDTO;
import app.services.api.entity.Hour;

public class HourTransformer {

    public static Hour dtoToEntity(HourDTO hdto) {
        Hour h = new Hour();

        h.setAPCPsfc(hdto.getAPCPsfc());
        h.setRH2m(hdto.getRH2m());

        return h;
    }

    public static HourDTO entityToDto(Hour h) {
        HourDTO hdto = new HourDTO();

        hdto.setAPCPsfc(h.getAPCPsfc());
        hdto.setRH2m(h.getRH2m());

        return hdto;
    }
}
