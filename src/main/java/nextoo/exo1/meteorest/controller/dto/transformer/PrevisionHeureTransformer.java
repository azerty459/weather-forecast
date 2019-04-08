package nextoo.exo1.meteorest.controller.dto.transformer;

import nextoo.exo1.meteorest.service.entites.PrevisionHeure;
import nextoo.exo1.meteorest.controller.dto.PrevisionHeureDTO;

public class PrevisionHeureTransformer {

    public static PrevisionHeureDTO entityToDto(PrevisionHeure ph){
        PrevisionHeureDTO phdto = new PrevisionHeureDTO();
        phdto.setHumidity(ph.getHumidity());
        return phdto;
    }

    public static PrevisionHeure dtoToEntity(PrevisionHeureDTO phdto){
        PrevisionHeure ph = new PrevisionHeure();
        ph.setHumidity(phdto.getHumidity());
        return  ph;
    }

}
