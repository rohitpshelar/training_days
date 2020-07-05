package com.riomed.portal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModuleDto {
    private Long modId;
    private String modName;
    private String modCode;
    private String modStatus;
    private Long modQuestionLimit;
	private Long modWeightingPassPercent;
	private boolean modRandomQuestions;

}
