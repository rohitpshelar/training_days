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

import com.riomed.portal.dto.QuestionDto;
import com.riomed.portal.service.QuestionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/question")
@AllArgsConstructor
public class QuestionController {

	private QuestionService questionService;

	@PostMapping
	public ResponseEntity<QuestionDto> saveQuestion(@RequestBody QuestionDto questionDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(questionService.saveQuestion(questionDto));
	}

	@GetMapping("bymodule")
	public ResponseEntity<List<QuestionDto>> getQuestionByQueModId(@RequestBody QuestionDto questionDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(questionService.getQuestionsByQueModId(questionDto.getQueModId()));
	}

	@GetMapping("bymodule/{id}")
	public ResponseEntity<List<QuestionDto>> getQuestionByQueModId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(questionService.getQuestionsByQueModId(id));
	}

	@GetMapping
	public ResponseEntity<List<QuestionDto>> getQuestion() {
		return ResponseEntity.status(HttpStatus.CREATED).body(questionService.getQuestions());

	}

}
