package com.riomed.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riomed.portal.model.CompetencyTestAnswer;

@Repository
public interface CompetencyTestAnswerRepository extends JpaRepository<CompetencyTestAnswer, Long> {

	CompetencyTestAnswer findByCtaModIdAndCtaQueIdAndCtaCtrId(Long ctrModId, Long queId, Long ctaCtrId);
	
	

}
