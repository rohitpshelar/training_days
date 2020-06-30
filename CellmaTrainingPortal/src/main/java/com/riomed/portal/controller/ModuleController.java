package com.riomed.portal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riomed.portal.dto.ModuleDto;
import com.riomed.portal.service.ModuleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/module")
@AllArgsConstructor
public class ModuleController {
	
	private ModuleService moduleService;
	
	   @PostMapping
	    public ResponseEntity<ModuleDto> createModule(@RequestBody ModuleDto moduleDto) {
	        return ResponseEntity.status(HttpStatus.CREATED)
	                .body(moduleService.save(moduleDto));
	    }
	   
	   @GetMapping
	   public ResponseEntity<List<ModuleDto>> getModules() {
		   return ResponseEntity.status(HttpStatus.OK).body(moduleService.getModules());
	   }

}
