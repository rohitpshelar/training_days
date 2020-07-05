package com.riomed.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riomed.portal.model.CompetencyTestResult;

@Repository
public interface CompetencyTestResultReposiroty extends JpaRepository<CompetencyTestResult, Long>{

}
