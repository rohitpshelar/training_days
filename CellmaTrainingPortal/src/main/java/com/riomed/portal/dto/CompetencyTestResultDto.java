package com.riomed.portal.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetencyTestResultDto {
	
	private Long ctrId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String ctrUsername;
	private String ctrModCode;
	
	private Long ctrModId;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long ctrModQuestionLimit;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long ctrPercentageScore;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String ctrResult;
	
	private List<QuestionDto> questionDtos;

}
