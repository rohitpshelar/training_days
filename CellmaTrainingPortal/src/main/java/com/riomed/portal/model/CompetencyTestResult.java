package com.riomed.portal.model;

import java.time.Instant;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetencyTestResult {
	
	private Long ctrId;
	private String ctrUsername;
	private String ctrModCode;
	private Long ctrScore;
	private String ctrResult;
	private Instant ctrCreated;

}
