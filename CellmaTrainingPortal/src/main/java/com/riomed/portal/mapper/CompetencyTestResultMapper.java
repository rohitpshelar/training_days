package com.riomed.portal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riomed.portal.dto.CompetencyTestResultDto;
import com.riomed.portal.model.CompetencyTestResult;
import com.riomed.portal.model.User;

@Mapper
public interface CompetencyTestResultMapper {
	
	CompetencyTestResultDto CompetencyTestResultToDto(CompetencyTestResult competencyTestResult);
	
	
	@Mapping( target = "ctrCreated", expression = "java(java.time.Instant.now())")
	@Mapping(target = "ctrUsername", source = "user.username")
	CompetencyTestResult DtoToCompetencyTestResult(CompetencyTestResultDto competencyTestResultDto, User user);
	
	@Mapping( target = "ctrCreated", expression = "java(java.time.Instant.now())")
	@Mapping(target = "ctrUsername", source = "user")
	CompetencyTestResult DtoToCompetencyTestResult(CompetencyTestResultDto competencyTestResultDto, String user);

}
