package com.ro.demo.repository;

import com.ro.demo.model.Comment;
import com.ro.demo.model.Post;
import com.ro.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
