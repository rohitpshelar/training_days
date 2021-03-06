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
public class CompetencyTestResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ctrId;
	@NotBlank(message = "Username is required")
	private String ctrUsername;
	@NotBlank(message = "Username is required")
	private String ctrModCode;
	private Long ctrModId;
	private Long ctrModQuestionLimit;
	private Long ctrPercentageScore;
	private String ctrResult;
	private Instant ctrCreated;

}
