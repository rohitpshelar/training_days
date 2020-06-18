package com.ro.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ro.demo.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

}
