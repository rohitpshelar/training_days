package com.riomed.portal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riomed.portal.dto.CompetencyTestSettingDto;
import com.riomed.portal.model.CompetencyTestSetting;
import com.riomed.portal.model.User;

@Mapper
public interface CompetencyTestSettingMapper {
	
	CompetencyTestSettingDto CompetencyTestSettingToDto(CompetencyTestSetting competencyTestSetting);
	
	@Mapping( target = "ctsCreated", expression = "java(java.time.Instant.now())")
	CompetencyTestSetting DtoToCompetencyTestSetting(CompetencyTestSettingDto competencyTestSettingDto, User user);

}
