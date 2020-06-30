package com.riomed.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riomed.portal.model.QuestionOption;

@Repository
public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Long>{

	List<QuestionOption> findQuestionOptionByoptQueId(Long optQueId);
	
	

}
