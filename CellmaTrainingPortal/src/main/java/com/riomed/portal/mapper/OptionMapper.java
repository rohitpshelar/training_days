package com.riomed.portal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.riomed.portal.dto.QuestionOptionDto;
import com.riomed.portal.model.QuestionOption;
import com.riomed.portal.model.User;

@Mapper
public interface OptionMapper {
	
	QuestionOptionDto optionToDto(QuestionOption  questionOption);
	
	@Mapping(target = "optCreated" , expression = "java(java.time.Instant.now())")
	@Mapping(target = "optCreatedBy", source = "user.username")
	QuestionOption dtoToOption(QuestionOptionDto questionOptionDto, User user);

}
