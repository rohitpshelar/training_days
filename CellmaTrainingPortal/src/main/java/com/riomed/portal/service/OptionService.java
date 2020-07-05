package com.riomed.portal.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.riomed.portal.dto.QuestionOptionDto;
import com.riomed.portal.exceptions.CellmaTrainingPortalException;
import com.riomed.portal.mapper.QuestionOptionMapper;
import com.riomed.portal.model.Question;
import com.riomed.portal.model.QuestionOption;
import com.riomed.portal.repository.QuestionOptionRepository;
import com.riomed.portal.repository.QuestionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OptionService {
	
	private QuestionOptionRepository questionOptionRepository;
	private QuestionOptionMapper questionOptionMapper;
	private QuestionRepository questionRepository;
	private AuthService authService;
	
	
	
	public QuestionOptionDto saveOption(QuestionOptionDto questionOptionDto) {
		questionOptionDto.setOptStatus("Approved");
		QuestionOption questionOption =  questionOptionRepository.save(questionOptionMapper.dtoToQuestionOption(questionOptionDto, authService.getCurrentUser()));
		questionOptionDto.setOptId(questionOption.getOptId());
		return questionOptionDto;
	}


	public List<QuestionOptionDto> getOptionByQuestionId(Long id) {
		Question question = questionRepository.findById(id).orElseThrow(() -> new CellmaTrainingPortalException("getOptionByQuestionId Question not found with Id :" + id));
			return	questionOptionRepository.findQuestionOptionByoptQueId(question.getQueId()).stream().map(questionOptionMapper::questionOptionToDto).collect(toList());
	}

}
