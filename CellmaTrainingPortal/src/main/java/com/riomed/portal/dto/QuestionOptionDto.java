package com.riomed.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long optWeighting;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String optStatus;
	private boolean selected;

}
