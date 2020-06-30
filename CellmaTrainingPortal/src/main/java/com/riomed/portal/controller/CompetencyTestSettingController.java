package com.riomed.portal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riomed.portal.dto.CompetencyTestSettingDto;
import com.riomed.portal.service.CompetencyTestSettingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/testsetting")
@AllArgsConstructor
public class CompetencyTestSettingController {
	
	private CompetencyTestSettingService competencyTestSettingService;
	
	@PostMapping
	public ResponseEntity<CompetencyTestSettingDto> addTestSetting(@RequestBody CompetencyTestSettingDto competencyTestSettingDto) {
	return ResponseEntity.status(HttpStatus.CREATED).body(competencyTestSettingService.addTestSetting(competencyTestSettingDto));
	}

}
