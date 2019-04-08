package nextoo.exo1.meteorest.controller.dto.transformer;

import nextoo.exo1.meteorest.service.entites.PrevisionSemaine;
import nextoo.exo1.meteorest.controller.dto.PrevisionSemaineDTO;

public class PrevisionSemaineTransformer {

    public static PrevisionSemaineDTO entityToDto(PrevisionSemaine ps){
        PrevisionSemaineDTO psdto = new PrevisionSemaineDTO();
        psdto.setCurrent(PrevisionJourTransformer.entityToDto(ps.getCurrent()));
        psdto.setJ0(PrevisionJourTransformer.entityToDto(ps.getJ0()));
        psdto.setJ1(PrevisionJourTransformer.entityToDto(ps.getJ1()));
        psdto.setJ2(PrevisionJourTransformer.entityToDto(ps.getJ2()));
        psdto.setJ3(PrevisionJourTransformer.entityToDto(ps.getJ3()));
        psdto.setVille(VilleTransformer.entityToDto(ps.getVille()));
        return psdto;
    }

    public static PrevisionSemaine dtoToEntity(PrevisionSemaineDTO psdto){
        PrevisionSemaine ps = new PrevisionSemaine();
        ps.setCurrent(PrevisionJourTransformer.dtoToEntity(psdto.getCurrent()));
        ps.setJ0(PrevisionJourTransformer.dtoToEntity(psdto.getJ0()));
        ps.setJ1(PrevisionJourTransformer.dtoToEntity(psdto.getJ1()));
        ps.setJ2(PrevisionJourTransformer.dtoToEntity(psdto.getJ2()));
        ps.setJ3(PrevisionJourTransformer.dtoToEntity(psdto.getJ3()));
        ps.setVille(VilleTransformer.dtoToEntity(psdto.getVille()));
        return  ps;
    }
    
}
