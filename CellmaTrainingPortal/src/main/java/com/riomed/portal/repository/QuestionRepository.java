package com.riomed.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riomed.portal.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	List<Question> findQuestionByQueModId(Long queModId);

}
