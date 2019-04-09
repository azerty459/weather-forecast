package nextoo.exo1.meteorest.controller.dto.transformer;

import nextoo.exo1.meteorest.service.entites.PrevisionHeure;
import nextoo.exo1.meteorest.service.entites.PrevisionJour;
import nextoo.exo1.meteorest.controller.dto.PrevisionHeureDTO;
import nextoo.exo1.meteorest.controller.dto.PrevisionJourDTO;
import java.util.HashMap;
import java.util.Map;

public class PrevisionJourTransformer {

    public static PrevisionJourDTO entityToDto(PrevisionJour pj){
        PrevisionJourDTO pjdto = new PrevisionJourDTO();
        pjdto.setCondition(pj.getCondition());
        pjdto.setDateDuBulletin(pj.getDateDuBulletin());
        pjdto.setHumidite(pj.getHumidite());
        HashMap<String, PrevisionHeureDTO> previsions_par_heure = new HashMap<>();
        for (Map.Entry<String, PrevisionHeure> ph: pj.getParHeure().entrySet()) {
            previsions_par_heure.put(ph.getKey(), PrevisionHeureTransformer.entityToDto(ph.getValue()));
        }
        pjdto.setParHeure(previsions_par_heure);
        pjdto.setIcon(pj.getIcon());
        pjdto.setTemperature(pj.getTemperature());
        pjdto.setTemperatureMax(pj.getTemperatureMax());
        pjdto.setTemperatureMin(pj.getTemperatureMin());
        return pjdto;
    }

    public static PrevisionJour dtoToEntity(PrevisionJourDTO pjdto){
        PrevisionJour pj = new PrevisionJour();
        pj.setCondition(pjdto.getCondition());
        pj.setDateDuBulletin(pjdto.getDateDuBulletin());
        pj.setHumidite(pjdto.getHumidite());
        HashMap<String, PrevisionHeure> previsions_par_heure = new HashMap<>();
        for (Map.Entry<String, PrevisionHeureDTO> ph: pjdto.getParHeure().entrySet()) {
            previsions_par_heure.put(ph.getKey(), PrevisionHeureTransformer.dtoToEntity(ph.getValue()));
        }
        pj.setParHeure(previsions_par_heure);
        pj.setIcon(pjdto.getIcon());
        pj.setTemperature(pjdto.getTemperature());
        pj.setTemperatureMax(pjdto.getTemperatureMax());
        pj.setTemperatureMin(pjdto.getTemperatureMin());
        return  pj;
    }
}
