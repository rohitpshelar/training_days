package com.riomed.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompetencyTestAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ctaId;
	@NotBlank(message = "Username is equired")
	private String ctaUseUsername;
	private Long ctaModId;
	private Long ctaCtrId;
	private Long ctaQueId;
	private Long ctaOptId;
	private Long ctaOptWeighting;

}
