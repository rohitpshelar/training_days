package com.riomed.portal.mapper;

import com.riomed.portal.dto.QuestionDto;
import com.riomed.portal.model.Question;
import com.riomed.portal.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-05T20:23:30+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionDto questionToDto(Question question) {
        if ( question == null ) {
            return null;
        }

        QuestionDto questionDto = new QuestionDto();

        questionDto.setQueId( question.getQueId() );
        questionDto.setQueText( question.getQueText() );
        questionDto.setQueType( question.getQueType() );
        questionDto.setQueModId( question.getQueModId() );
        questionDto.setQueMandatory( question.isQueMandatory() );
        questionDto.setQueStatus( question.getQueStatus() );

        return questionDto;
    }

    @Override
    public Question dtoToQuestion(QuestionDto questionDto, User user) {
        if ( questionDto == null && user == null ) {
            return null;
        }

        Question question = new Question();

        if ( questionDto != null ) {
            question.setQueId( questionDto.getQueId() );
            question.setQueText( questionDto.getQueText() );
            question.setQueType( questionDto.getQueType() );
            question.setQueModId( questionDto.getQueModId() );
            question.setQueMandatory( questionDto.isQueMandatory() );
            question.setQueStatus( questionDto.getQueStatus() );
        }
        if ( user != null ) {
            question.setQueCreatedBy( user.getUsername() );
        }
        question.setQueCreated( java.time.Instant.now() );

        return question;
    }
}
