package com.ro.demo.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ro.demo.dto.SubredditDto;
import com.ro.demo.model.Subreddit;
import com.ro.demo.repository.SubredditRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubredditService {

    private final SubredditRepository subredditRepository;
  // private final SubredditMapper subredditMapper;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
         
        Subreddit save = subredditRepository.save(mapSubredditDto(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(toList());
    }
//
//    public SubredditDto getSubreddit(Long id) {
//        Subreddit subreddit = subredditRepository.findById(id)
//                .orElseThrow(() -> new SpringRedditException("No subreddit found with ID - " + id));
//        return subredditMapper.mapSubredditToDto(subreddit);
//    }
    
    private SubredditDto mapToDto(Subreddit subreddit) {
    	return SubredditDto.builder().name(subreddit.getName()).id(subreddit.getId()).numberOfPosts(subreddit.getPosts().size()).build();
    }
    
    private Subreddit mapSubredditDto(SubredditDto dto) {
    	return Subreddit.builder().name(dto.getName()).description(dto.getDescription()).build();
	}
}
