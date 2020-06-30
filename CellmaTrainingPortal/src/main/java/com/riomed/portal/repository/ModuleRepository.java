package com.riomed.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riomed.portal.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

}
