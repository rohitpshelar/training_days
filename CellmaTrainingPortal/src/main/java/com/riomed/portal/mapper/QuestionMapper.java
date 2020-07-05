package com.riomed.portal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riomed.portal.dto.QuestionDto;
import com.riomed.portal.model.Question;
import com.riomed.portal.model.User;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

	QuestionDto questionToDto(Question question);

	@Mapping(target = "queCreated", expression = "java(java.time.Instant.now())")
	@Mapping(target = "queCreatedBy", source = "user.username")
	Question dtoToQuestion(QuestionDto questionDto, User user);

}
