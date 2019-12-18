package fr.ia.meteo.meteo.api;

import fr.ia.meteo.meteo.api.dto.PrevisionDTO;
import fr.ia.meteo.meteo.api.dto.PrevisionHoraireDTO;
import fr.ia.meteo.meteo.api.dto.RootDTO;
import fr.ia.meteo.meteo.job.ConditionActuelle;
import fr.ia.meteo.meteo.job.Root;
import fr.ia.meteo.meteo.job.prevision.Prevision;
import fr.ia.meteo.meteo.job.prevision.PrevisionHoraire;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class DtoToDoConverter {

    private PrevisionDTO PrevisionDTO;
    private ModelMapper modelMapper = new ModelMapper();

    public Root convertDtoToDo(RootDTO rootDto) {

        Root root = new Root();
        List<PrevisionDTO> previsionDTOList = rootDto.getPrevisionDTOList();
        List<Prevision> previsionList = previsionDTOList.stream()
                .map(source -> mapPrevisionDtoToDo(source))
                .collect(Collectors.toList());
        root.setPrevisionList(previsionList);
        root.setConditionActuelle(modelMapper.map(rootDto.getConditionActuelleDTO(), ConditionActuelle.class));

        return root;

    }


    public Prevision mapPrevisionDtoToDo(PrevisionDTO previsionDTO) {
        Prevision prevision = modelMapper.map(previsionDTO, Prevision.class);
        List<PrevisionHoraireDTO> previsionHoraireDTOList = previsionDTO.getPrevisionHoraireListDTO().getPrevisionHoraireList();
        List<PrevisionHoraire> previsionHoraireList = previsionHoraireDTOList.stream()
                .map(x -> mapPrevisionHoraireDTOToDo(x))
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
