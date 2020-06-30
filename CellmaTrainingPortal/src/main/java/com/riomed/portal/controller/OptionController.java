package com.riomed.portal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riomed.portal.dto.QuestionOptionDto;
import com.riomed.portal.service.OptionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/option")
@AllArgsConstructor
public class OptionController {
	
	private OptionService optionService;
	
	@PostMapping
	public ResponseEntity<QuestionOptionDto> saveOptions(@RequestBody QuestionOptionDto questionOptionDto) {
		return ResponseEntity.status(HttpStatus.OK).body(optionService.saveOption(questionOptionDto));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<List<QuestionOptionDto>> getOptionByQuestionId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(optionService.getOptionByQuestionId(id));
		
	}
}
