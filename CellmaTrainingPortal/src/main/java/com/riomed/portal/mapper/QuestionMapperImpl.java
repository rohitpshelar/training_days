package com.riomed.portal.mapper;

import com.riomed.portal.dto.QuestionDto;
import com.riomed.portal.model.Question;
import com.riomed.portal.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-30T09:17:45+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionDto QuestionToDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDto questionDto = new QuestionDto();

        questionDto.setQueId( question.getQueId() );
        questionDto.setQueText( question.getQueText() );
        questionDto.setType( question.getType() );
        questionDto.setQueModId( question.getQueModId() );

        return questionDto;
    }

    @Override
    public Question DtoToQuestion(QuestionDto questionDto, User user) {
        if ( questionDto == null && user == null ) {
            return null;
        }

        Question question = new Question();

        if ( questionDto != null ) {
            question.setQueId( questionDto.getQueId() );
            question.setQueText( questionDto.getQueText() );
            question.setType( questionDto.getType() );
            question.setQueModId( questionDto.getQueModId() );
        }
        if ( user != null ) {
            question.setQueCreatedBy( user.getUsername() );
        }
        question.setQueCreated( java.time.Instant.now() );

        return question;
    }
}
