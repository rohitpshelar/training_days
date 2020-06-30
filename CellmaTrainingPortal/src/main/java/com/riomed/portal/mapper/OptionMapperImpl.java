package com.riomed.portal.mapper;

import com.riomed.portal.dto.QuestionOptionDto;
import com.riomed.portal.model.QuestionOption;
import com.riomed.portal.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-30T09:17:44+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class OptionMapperImpl implements OptionMapper {

    @Override
    public QuestionOptionDto optionToDto(QuestionOption questionOption) {
        if ( questionOption == null ) {
            return null;
        }

        QuestionOptionDto questionOptionDto = new QuestionOptionDto();

        questionOptionDto.setOptId( questionOption.getOptId() );
        questionOptionDto.setOptText( questionOption.getOptText() );
        questionOptionDto.setOptQueId( questionOption.getOptQueId() );
        questionOptionDto.setOptWeighting( questionOption.getOptWeighting() );

        return questionOptionDto;
    }

    @Override
    public QuestionOption dtoToOption(QuestionOptionDto questionOptionDto, User user) {
        if ( questionOptionDto == null && user == null ) {
            return null;
        }

        QuestionOption questionOption = new QuestionOption();

        if ( questionOptionDto != null ) {
            questionOption.setOptId( questionOptionDto.getOptId() );
            questionOption.setOptText( questionOptionDto.getOptText() );
            questionOption.setOptQueId( questionOptionDto.getOptQueId() );
            questionOption.setOptWeighting( questionOptionDto.getOptWeighting() );
        }
        if ( user != null ) {
            questionOption.setOptCreatedBy( user.getUsername() );
        }
        questionOption.setOptCreated( java.time.Instant.now() );

        return questionOption;
    }
}
