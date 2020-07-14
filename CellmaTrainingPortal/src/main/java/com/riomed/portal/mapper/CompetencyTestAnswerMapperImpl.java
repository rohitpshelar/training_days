package com.riomed.portal.mapper;

import com.riomed.portal.dto.CompetencyTestAnswerDto;
import com.riomed.portal.model.CompetencyTestAnswer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-14T15:25:37+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class CompetencyTestAnswerMapperImpl implements CompetencyTestAnswerMapper {

    @Override
    public CompetencyTestAnswerDto competencyTestAnswerToDto(CompetencyTestAnswer competencyTestAnswer) {
        if ( competencyTestAnswer == null ) {
            return null;
        }

        CompetencyTestAnswerDto competencyTestAnswerDto = new CompetencyTestAnswerDto();

        competencyTestAnswerDto.setCtaId( competencyTestAnswer.getCtaId() );
        competencyTestAnswerDto.setCtaUseUsername( competencyTestAnswer.getCtaUseUsername() );
        competencyTestAnswerDto.setCtaModId( competencyTestAnswer.getCtaModId() );
        competencyTestAnswerDto.setCtaQueId( competencyTestAnswer.getCtaQueId() );
        competencyTestAnswerDto.setCtaOptId( competencyTestAnswer.getCtaOptId() );
        competencyTestAnswerDto.setCtaCtrId( competencyTestAnswer.getCtaCtrId() );
        competencyTestAnswerDto.setCtaOptWeighting( competencyTestAnswer.getCtaOptWeighting() );

        return competencyTestAnswerDto;
    }

    @Override
    public CompetencyTestAnswer dtoToCompetencyTestAnswer(CompetencyTestAnswerDto competencyTestAnswerDto) {
        if ( competencyTestAnswerDto == null ) {
            return null;
        }

        CompetencyTestAnswer competencyTestAnswer = new CompetencyTestAnswer();

        competencyTestAnswer.setCtaId( competencyTestAnswerDto.getCtaId() );
        competencyTestAnswer.setCtaUseUsername( competencyTestAnswerDto.getCtaUseUsername() );
        competencyTestAnswer.setCtaModId( competencyTestAnswerDto.getCtaModId() );
        competencyTestAnswer.setCtaCtrId( competencyTestAnswerDto.getCtaCtrId() );
        competencyTestAnswer.setCtaQueId( competencyTestAnswerDto.getCtaQueId() );
        competencyTestAnswer.setCtaOptId( competencyTestAnswerDto.getCtaOptId() );
        competencyTestAnswer.setCtaOptWeighting( competencyTestAnswerDto.getCtaOptWeighting() );

        return competencyTestAnswer;
    }
}
