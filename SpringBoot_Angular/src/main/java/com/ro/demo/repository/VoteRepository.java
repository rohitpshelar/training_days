package com.ro.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ro.demo.model.Post;
import com.ro.demo.model.User;
import com.ro.demo.model.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
	  Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
