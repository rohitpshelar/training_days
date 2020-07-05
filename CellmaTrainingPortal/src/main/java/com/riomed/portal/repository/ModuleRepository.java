package com.riomed.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riomed.portal.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
	
	@Query("SELECT m FROM Module m WHERE LOWER(m.modCode) = LOWER(:modCode)")
	public Module findByModCode(@Param("modCode") String modCode);

}
