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
	private String Type;
	private Long queModId;
	private boolean mandatory;
	private List<QuestionOptionDto> questionOptionDtos;
	private String queStatus;
	
}
