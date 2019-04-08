package nextoo.exo1.meteorest.controller.dto.transformer;

import nextoo.exo1.meteorest.service.entites.Ville;
import nextoo.exo1.meteorest.controller.dto.VilleDTO;

public class VilleTransformer {

    public static VilleDTO entityToDto(Ville v){
        VilleDTO vdto = new VilleDTO();
        vdto.setNom(v.getNom());
        vdto.setAlt(v.getAlt());
        vdto.setLat(v.getLat());
        vdto.setLon(v.getLon());
        return vdto;
    }

    public static Ville dtoToEntity(VilleDTO vdto){
        Ville v = new Ville();
        v.setNom(vdto.getNom());
        v.setAlt(vdto.getAlt());
        v.setLat(v.getLat());
        v.setLon(v.getLon());
        return  v;
    }
    
}
