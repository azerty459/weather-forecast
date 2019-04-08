package com.nextoo.asenoussi.ex1.dto.transformer;

import com.nextoo.asenoussi.ex1.api.service.entity.CityInfo;
import com.nextoo.asenoussi.ex1.dto.CityInfoDto;

public class CityInfoTransformer {
	private CityInfoTransformer() {}
	
	public static CityInfoDto entityToDto(CityInfo cityInfos) {
		if(cityInfos != null) {
			CityInfoDto cityInfosDto = new CityInfoDto();
			
			cityInfosDto.setLatitude(cityInfos.getLatitude());
			cityInfosDto.setLongitude(cityInfos.getLongitude());
			cityInfosDto.setNomLocalite(cityInfos.getNomLocalite());
			cityInfosDto.setCoucheSoleil(cityInfos.getCoucheSoleil());
			cityInfosDto.setLeveSoleil(cityInfos.getLeveSoleil());
			
			return cityInfosDto;
		}
		return null;
	}
	
	public static CityInfo dtoToEntity(CityInfoDto cityInfosDto) {
		if(cityInfosDto != null) {
			CityInfo cityInfos = new CityInfo();
			
			cityInfos.setLatitude(cityInfosDto.getLatitude());
			cityInfos.setLongitude(cityInfosDto.getLongitude());
			cityInfos.setNomLocalite(cityInfosDto.getNomLocalite());
			cityInfos.setCoucheSoleil(cityInfosDto.getCoucheSoleil());
			cityInfos.setLeveSoleil(cityInfosDto.getLeveSoleil());
			
			return cityInfos;
		}
		return null;
	}
}
