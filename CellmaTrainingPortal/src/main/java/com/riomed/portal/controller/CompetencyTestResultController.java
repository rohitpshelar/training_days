package com.riomed.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riomed.portal.dto.CompetencyTestResultDto;
import com.riomed.portal.service.CompetencyTestResultService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class CompetencyTestResultController {
	
	private CompetencyTestResultService competencyTestResultService;
	
	@PostMapping
	public ResponseEntity<CompetencyTestResultDto> startCompetencyTest(@RequestBody CompetencyTestResultDto competencyTestResultDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(competencyTestResultService.saveCompetencyTestResult(competencyTestResultDto));

	}
	
	@PostMapping("/code/{code}")
	public ResponseEntity<CompetencyTestResultDto> saveCompetencyTestResult(@PathVariable String code) {
		CompetencyTestResultDto competencyTestResultDto = new CompetencyTestResultDto();
		competencyTestResultDto.setCtrModCode(code);
		return ResponseEntity.status(HttpStatus.CREATED).body(competencyTestResultService.saveCompetencyTestResult(competencyTestResultDto));

	}
	
	@PostMapping("/moduleid/{id}")
	public ResponseEntity<CompetencyTestResultDto> saveCompetencyTestResult(@PathVariable Long id) {
		CompetencyTestResultDto competencyTestResultDto = new CompetencyTestResultDto();
		competencyTestResultDto.setCtrModId(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(competencyTestResultService.saveCompetencyTestResult(competencyTestResultDto));

	}
	
	@PostMapping("/submit")
	public ResponseEntity<CompetencyTestResultDto> submitCompetencyTestResult(@RequestBody CompetencyTestResultDto competencyTestResultDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(competencyTestResultService.submitCompetencyTestResult(competencyTestResultDto));

	}
	

}
