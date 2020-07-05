package com.riomed.portal.mapper;

import com.riomed.portal.dto.CompetencyTestResultDto;
import com.riomed.portal.model.CompetencyTestResult;
import com.riomed.portal.model.User;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-05T20:23:30+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11 (Oracle Corporation)"
)
@Component
public class CompetencyTestResultMapperImpl implements CompetencyTestResultMapper {

    @Override
    public CompetencyTestResultDto CompetencyTestResultToDto(CompetencyTestResult competencyTestResult) {
        if ( competencyTestResult == null ) {
            return null;
        }

        CompetencyTestResultDto competencyTestResultDto = new CompetencyTestResultDto();

        competencyTestResultDto.setCtrId( competencyTestResult.getCtrId() );
        competencyTestResultDto.setCtrUsername( competencyTestResult.getCtrUsername() );
        competencyTestResultDto.setCtrModCode( competencyTestResult.getCtrModCode() );
        competencyTestResultDto.setCtrModId( competencyTestResult.getCtrModId() );
        competencyTestResultDto.setCtrModQuestionLimit( competencyTestResult.getCtrModQuestionLimit() );
        competencyTestResultDto.setCtrPercentageScore( competencyTestResult.getCtrPercentageScore() );
        competencyTestResultDto.setCtrResult( competencyTestResult.getCtrResult() );

        return competencyTestResultDto;
    }

    @Override
    public CompetencyTestResult DtoToCompetencyTestResult(CompetencyTestResultDto competencyTestResultDto, User user) {
        if ( competencyTestResultDto == null && user == null ) {
            return null;
        }

        CompetencyTestResult competencyTestResult = new CompetencyTestResult();

        if ( competencyTestResultDto != null ) {
            competencyTestResult.setCtrId( competencyTestResultDto.getCtrId() );
            competencyTestResult.setCtrModCode( competencyTestResultDto.getCtrModCode() );
            competencyTestResult.setCtrModId( competencyTestResultDto.getCtrModId() );
            competencyTestResult.setCtrModQuestionLimit( competencyTestResultDto.getCtrModQuestionLimit() );
            competencyTestResult.setCtrPercentageScore( competencyTestResultDto.getCtrPercentageScore() );
            competencyTestResult.setCtrResult( competencyTestResultDto.getCtrResult() );
        }
        if ( user != null ) {
            competencyTestResult.setCtrUsername( user.getUsername() );
        }
        competencyTestResult.setCtrCreated( java.time.Instant.now() );

        return competencyTestResult;
    }
}
