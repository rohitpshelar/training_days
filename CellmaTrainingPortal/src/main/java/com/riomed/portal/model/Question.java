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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long queId;
	@NotBlank(message = "Question text is required")
	private String queText;
	@NotBlank(message = "Question type is required, like : select, select+image,text, etc.")
	private String Type;
	@NotBlank(message = "Question Module Id is required")
	private Long queModId;
	private boolean queMandatory;
	private Instant queCreated;
	private String queCreatedBy;
	private String queStatus;
	
}
