package com.riomed.portal.mapper;

import com.riomed.portal.dto.QuestionOptionDto;
import com.riomed.portal.model.QuestionOption;
import com.riomed.portal.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-14T15:25:37+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class QuestionOptionMapperImpl implements QuestionOptionMapper {

    @Override
    public QuestionOptionDto questionOptionToDto(QuestionOption questionOption) {
        if ( questionOption == null ) {
            return null;
        }

        QuestionOptionDto questionOptionDto = new QuestionOptionDto();

        questionOptionDto.setOptId( questionOption.getOptId() );
        questionOptionDto.setOptText( questionOption.getOptText() );
        questionOptionDto.setOptQueId( questionOption.getOptQueId() );
        questionOptionDto.setOptWeighting( questionOption.getOptWeighting() );
        questionOptionDto.setOptStatus( questionOption.getOptStatus() );

        return questionOptionDto;
    }

    @Override
    public QuestionOption dtoToQuestionOption(QuestionOptionDto questionOptionDto, User user) {
        if ( questionOptionDto == null && user == null ) {
            return null;
        }

        QuestionOption questionOption = new QuestionOption();

        if ( questionOptionDto != null ) {
            questionOption.setOptId( questionOptionDto.getOptId() );
            questionOption.setOptText( questionOptionDto.getOptText() );
            questionOption.setOptQueId( questionOptionDto.getOptQueId() );
            questionOption.setOptWeighting( questionOptionDto.getOptWeighting() );
            questionOption.setOptStatus( questionOptionDto.getOptStatus() );
        }
        if ( user != null ) {
            questionOption.setOptCreatedBy( user.getUsername() );
        }
        questionOption.setOptCreated( java.time.Instant.now() );

        return questionOption;
    }

    @Override
    public QuestionOption dtoToQuestionOption(QuestionOptionDto questionOptionDto, String user) {
        if ( questionOptionDto == null && user == null ) {
            return null;
        }

        QuestionOption questionOption = new QuestionOption();

        if ( questionOptionDto != null ) {
            questionOption.setOptId( questionOptionDto.getOptId() );
            questionOption.setOptText( questionOptionDto.getOptText() );
            questionOption.setOptQueId( questionOptionDto.getOptQueId() );
            questionOption.setOptWeighting( questionOptionDto.getOptWeighting() );
            questionOption.setOptStatus( questionOptionDto.getOptStatus() );
        }
        if ( user != null ) {
            questionOption.setOptCreatedBy( user );
        }
        questionOption.setOptCreated( java.time.Instant.now() );

        return questionOption;
    }
}
