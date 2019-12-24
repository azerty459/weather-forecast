package fr.ia.meteo.meteo.api.dto;

import fr.ia.meteo.meteo.api.dto.prevision.PrevisionDTO;
import fr.ia.meteo.meteo.api.dto.prevision.PrevisionHoraireDTO;
import fr.ia.meteo.meteo.entity.ConditionActuelle;
import fr.ia.meteo.meteo.entity.Root;
import fr.ia.meteo.meteo.entity.prevision.Prevision;
import fr.ia.meteo.meteo.entity.prevision.PrevisionHoraire;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoToDoConverter {

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    public DtoToDoConverter( ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//    }

    public Root convertDtoToDo(RootDTO rootDto) {
        if(rootDto == null) {
            return null;
        }

        Root root = new Root();
        List<PrevisionDTO> previsionDTOList = rootDto.getPrevisionDTOList();
        List<Prevision> previsionList = previsionDTOList.stream()
                .map(this::mapPrevisionDtoToDo)
                .collect(Collectors.toList());
        root.setPrevisionList(previsionList);
        root.setConditionActuelle(modelMapper.map(rootDto.getConditionActuelleDTO(), ConditionActuelle.class));

        return root;
    }


    public Prevision mapPrevisionDtoToDo(PrevisionDTO previsionDTO) {
        Prevision prevision = modelMapper.map(previsionDTO, Prevision.class);
        List<PrevisionHoraireDTO> previsionHoraireDTOList = previsionDTO.getPrevisionHoraireListDTO().getPrevisionHoraireList();
        List<PrevisionHoraire> previsionHoraireList = previsionHoraireDTOList.stream()
                .map(this::mapPrevisionHoraireDTOToDo)
                .collect(Collectors.toList());
        prevision.setPrevisionHoraireList(previsionHoraireList);
        prevision.setDate(previsionDTO.getDate());
        prevision.setCondition(previsionDTO.getCondition());
        prevision.setTempMax(previsionDTO.getTempMax());
        prevision.setTempMin(previsionDTO.getTempMin());
        return prevision;

    }


    public PrevisionHoraire mapPrevisionHoraireDTOToDo(PrevisionHoraireDTO previsionHoraireDTO) {
        PrevisionHoraire previsionHoraire = modelMapper.map(previsionHoraireDTO, PrevisionHoraire.class);
        previsionHoraire.setCondition(previsionHoraireDTO.getCondition());
        previsionHoraire.setTauxHumidite(previsionHoraireDTO.getTauxHumidite());
        previsionHoraire.setHeurePrevisionHoraire(previsionHoraireDTO.getHeurePrevisionHoraire());
        return previsionHoraire;
    }

}
