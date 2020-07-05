package com.riomed.portal.mapper;

import org.mapstruct.Mapper;

import com.riomed.portal.dto.CompetencyTestAnswerDto;
import com.riomed.portal.model.CompetencyTestAnswer;

@Mapper
public interface CompetencyTestAnswerMapper {

	
	CompetencyTestAnswerDto competencyTestAnswerToDto(CompetencyTestAnswer competencyTestAnswer);
	
	
	CompetencyTestAnswer dtoToCompetencyTestAnswer(CompetencyTestAnswerDto competencyTestAnswerDto);
}
