package com.riomed.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetencyTestSettingDto {
	
	private Long ctsId;
	private Long ctsQuestionLimit;
	private Long ctsWeightingPassPercent;
	private String ctsModCode;
	private boolean ctsRandomQuestions;
	private String ctsCreatedBy;
	

}
