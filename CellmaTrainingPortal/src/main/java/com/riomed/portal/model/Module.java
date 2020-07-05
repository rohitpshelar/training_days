package com.riomed.portal.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Module {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long modId;
    @NotBlank(message = "Module name is required")
    private String modName;
    @NotBlank(message = "Module code is required")
    private String modCode;
    @NotBlank(message = "Module status is required")
    private String modStatus;
    private Instant modCreated;
    private String modCreatedBy;
	@NotBlank(message = "Question limit is required")
	private Long modQuestionLimit;
	@NotBlank(message = "Weighting Pass Percent is required")
	private Long modWeightingPassPercent;
	private boolean modRandomQuestions;
    
}
