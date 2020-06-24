package com.ro.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.ro.demo.dto.SubredditDto;
import com.ro.demo.model.Post;
import com.ro.demo.model.Subreddit;

@Mapper(componentModel = "spring")
public interface  SubredditMapper {
	
	@Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts() ))")
	SubredditDto mapSubredditToDto(Subreddit subreddit);
	
	default Integer mapPosts(List<Post> numberOfPosts) {return numberOfPosts.size();}

}
