package com.riomed.portal.service;

import org.springframework.stereotype.Service;

import com.riomed.portal.dto.CompetencyTestSettingDto;
import com.riomed.portal.mapper.CompetencyTestSettingMapper;
import com.riomed.portal.model.CompetencyTestSetting;
import com.riomed.portal.repository.CompetencyTestSettingRepository;

@Service
public class CompetencyTestSettingService {
	
	private CompetencyTestSettingRepository competencyTestSettingRepository;
	private CompetencyTestSettingMapper competencyTestSettingMapper;
	private AuthService authService;
	
	
	public CompetencyTestSettingDto addTestSetting(CompetencyTestSettingDto competencyTestSettingDto) {
		CompetencyTestSetting competencyTestSetting = 	competencyTestSettingRepository.save(competencyTestSettingMapper.DtoToCompetencyTestSetting(competencyTestSettingDto, authService.getCurrentUser()));
		competencyTestSettingDto.setCtsId(competencyTestSetting.getCtsId());
		return competencyTestSettingDto;
		
	}

}
