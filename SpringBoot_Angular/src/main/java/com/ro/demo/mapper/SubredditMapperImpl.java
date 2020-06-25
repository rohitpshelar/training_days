package com.ro.demo.mapper;

import com.ro.demo.dto.SubredditDto;
import com.ro.demo.model.Subreddit;
import com.ro.demo.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-24T23:12:01+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class SubredditMapperImpl implements SubredditMapper {

    @Override
    public SubredditDto mapSubredditToDto(Subreddit subreddit) {
        if ( subreddit == null ) {
            return null;
        }

        SubredditDto subredditDto = new SubredditDto();

        subredditDto.setId( subreddit.getId() );
        subredditDto.setName( subreddit.getName() );
        subredditDto.setDescription( subreddit.getDescription() );

        subredditDto.setNumberOfPosts( mapPosts(subreddit.getPosts()) );

        return subredditDto;
    }

    @Override
    public Subreddit mapDtoToSubreddit(SubredditDto subredditDto, User user) {
        if ( subredditDto == null && user == null ) {
            return null;
        }

        Subreddit subreddit = new Subreddit();

        if ( subredditDto != null ) {
            subreddit.setId( subredditDto.getId() );
            subreddit.setName( subredditDto.getName() );
            subreddit.setDescription( subredditDto.getDescription() );
        }
        if ( user != null ) {
            subreddit.setUser( user );
        }
        subreddit.setCreatedDate( java.time.Instant.now() );

        return subreddit;
    }
}
