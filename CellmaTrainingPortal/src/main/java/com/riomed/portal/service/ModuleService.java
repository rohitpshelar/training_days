package com.riomed.portal.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riomed.portal.dto.ModuleDto;
import com.riomed.portal.mapper.ModuleMapper;
import com.riomed.portal.model.Module;
import com.riomed.portal.repository.ModuleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModuleService {
	
	private final AuthService authService;
	private ModuleMapper moduleMapper;
	private ModuleRepository moduleRepository;
	
	@Transactional
	public ModuleDto save(ModuleDto moduleDto) {
		moduleDto.setModStatus("Approved");
		Module save = moduleRepository.save(moduleMapper.mapDtoToModule(moduleDto, authService.getCurrentUser()));
		moduleDto.setModId(save.getModId());
		return moduleDto;
	}

	@Transactional(readOnly = true)
	public List<ModuleDto> getModules() {
		return moduleRepository.findAll().stream().map(moduleMapper::moduleToDto).collect(toList());
	}
	
	@Transactional(readOnly = true)
	public List<ModuleDto> getModules(Long id) {
		return moduleRepository.findById(id).stream().map(moduleMapper::moduleToDto).collect(toList());
	}

}
