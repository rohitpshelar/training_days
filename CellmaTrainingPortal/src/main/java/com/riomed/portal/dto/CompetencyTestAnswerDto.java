package com.riomed.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompetencyTestAnswerDto {
	
	private Long ctaId;
	private String ctaUseUsername;
	private Long ctaModId;
	private Long ctaQueId;
	private Long ctaOptId;
	private Long ctaCtrId;
	private Long ctaOptWeighting;

}
