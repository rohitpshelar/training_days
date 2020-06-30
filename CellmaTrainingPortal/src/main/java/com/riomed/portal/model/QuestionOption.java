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
public class QuestionOption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long optId;
	@NotBlank(message = "Option text is required")
	private String optText;
	@NotBlank(message = "Question Id is required to link Option")
	private Long optQueId;
	@NotBlank(message = "Option weighting is required")
	private Long optWeighting;
	private Instant optCreated;
	@NotBlank(message = "Option createdby is required")
	private String optCreatedBy;
	private String optStatus;
	
	
	
	
	

}
