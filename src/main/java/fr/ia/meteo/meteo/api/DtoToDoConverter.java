package fr.ia.meteo.meteo.api;

import fr.ia.meteo.meteo.api.dto.PrevisionDTO;
import fr.ia.meteo.meteo.api.dto.PrevisionHoraireDTO;
import fr.ia.meteo.meteo.api.dto.RootDTO;
import fr.ia.meteo.meteo.job.Root;
import fr.ia.meteo.meteo.job.prevision.Prevision;
import fr.ia.meteo.meteo.job.prevision.PrevisionHoraire;
import fr.ia.meteo.meteo.job.prevision.PrevisionHoraireList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DtoToDoConverter {
    @Autowired
    private ModelMapper modelMapper;
    private PrevisionDTO PrevisionDTO;

    public Root convertDtoToDo(RootDTO rootDto) {
        Root root = new Root();
        List<PrevisionDTO> previsionDTOList = rootDto.getPrevisionDTOList();
        List<Prevision> previsionList = previsionDTOList.stream()
                .map(previsionDTO -> mapPrevisionDtoToDo(previsionDTO))
                .collect(Collectors.toList());

        root.setPrevisionList(previsionList);
        return root;
    }


    public Prevision mapPrevisionDtoToDo(PrevisionDTO previsionDTO) {
        Prevision prevision = modelMapper.map(previsionDTO, Prevision.class);
        HashMap<String, PrevisionHoraireDTO> previsionHoraireDTOList = previsionDTO.getPrevisionHoraireListDTO().getPrevisionHoraireList();

    }


    public HashMap<String, PrevisionHoraire> mapPrevisionHoraireDTOToDo(){
        //todo
        return null;
    }

}
