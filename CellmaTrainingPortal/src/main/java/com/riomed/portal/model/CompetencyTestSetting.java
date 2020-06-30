package com.riomed.portal.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetencyTestSetting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ctsId;
	@NotBlank(message = "Question limit is required")
	private Long ctsQuestionLimit;
	@NotBlank(message = "Weighting Pass Percent is required")
	private Long ctsWeightingPassPercent;
	@NotBlank(message = "test module is required")
	private String ctsModCode;
	private boolean ctsRandomQuestions;
	private Instant ctsCreated;
	private String ctsCreatedBy;
	

}
