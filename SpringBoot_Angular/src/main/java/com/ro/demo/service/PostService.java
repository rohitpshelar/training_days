package com.ro.demo.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ro.demo.dto.PostRequest;
import com.ro.demo.dto.PostResponse;
import com.ro.demo.exceptions.PostNotFoundException;
import com.ro.demo.exceptions.SubredditNotFoundException;
import com.ro.demo.mapper.PostMapper;
import com.ro.demo.model.Post;
import com.ro.demo.model.Subreddit;
import com.ro.demo.model.User;
import com.ro.demo.repository.PostRepository;
import com.ro.demo.repository.SubredditRepository;
import com.ro.demo.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
	
		private final PostRepository postRepository;
	    private final SubredditRepository subredditRepository;
	    private final UserRepository userRepository;
	    private final AuthService authService;
	    private final PostMapper postMapper;

	    public void save(PostRequest postRequest) {
	        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
	                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
	        postRepository.save(postMapper.map(postRequest, subreddit, authService.getCurrentUser()));
	    }
	    
//	    public void save(PostRequest postRequest) {
//	        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
//	                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
//	        postRepository.save(postMapper.map(postRequest, subreddit, authService.getCurrentUser()));
//	    }

	    @Transactional(readOnly = true)
	    public PostResponse getPost(Long id) {
	        Post post = postRepository.findById(id)
	                .orElseThrow(() -> new PostNotFoundException(id.toString()));
	        return postMapper.mapToDto(post);
	    }

	    @Transactional(readOnly = true)
	    public List<PostResponse> getAllPosts() {
	        return postRepository.findAll()
	                .stream()
	                .map(postMapper::mapToDto)
	                .collect(toList());
	    }

	    @Transactional(readOnly = true)
	    public List<PostResponse> getPostsBySubreddit(Long subredditId) {
	        Subreddit subreddit = subredditRepository.findById(subredditId)
	                .orElseThrow(() -> new SubredditNotFoundException(subredditId.toString()));
	        List<Post> posts = postRepository.findAllBySubreddit(subreddit);
	        return posts.stream().map(postMapper::mapToDto).collect(toList());
	    }

	    @Transactional(readOnly = true)
	    public List<PostResponse> getPostsByUsername(String username) {
	        User user = userRepository.findByUsername(username)
	                .orElseThrow(() -> new UsernameNotFoundException(username));
	        return postRepository.findByUser(user)
	                .stream()
	                .map(postMapper::mapToDto)
	                .collect(toList());
	    }
	   
}
