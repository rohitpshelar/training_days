package com.riomed.portal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto {
	
	private Long queId;
	private String queText;
	private String queType;
	private Long queModId;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private boolean queMandatory;
	private List<QuestionOptionDto> questionOptionDtos;
	//@JsonProperty(access = Access.WRITE_ONLY)
	private String queStatus;
	
}
