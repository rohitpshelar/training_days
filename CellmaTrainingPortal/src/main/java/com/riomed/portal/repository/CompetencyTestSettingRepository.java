package com.riomed.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riomed.portal.model.CompetencyTestSetting;

@Repository
public interface CompetencyTestSettingRepository extends JpaRepository<CompetencyTestSetting, Long> {
	
	

}
