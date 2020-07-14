package com.riomed.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionOptionDto {

	private Long optId;
	private String optText;
	private Long optQueId;
	private Long optWeighting;
	private String optStatus;
	private boolean selected;

}
