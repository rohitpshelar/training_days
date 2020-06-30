package com.riomed.portal.service;

import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.riomed.portal.dto.QuestionOptionDto;
import com.riomed.portal.exceptions.CellmaTrainingPortalException;
import com.riomed.portal.mapper.OptionMapper;
import com.riomed.portal.model.QuestionOption;
import com.riomed.portal.model.Question;
import com.riomed.portal.repository.QuestionOptionRepository;
import com.riomed.portal.repository.QuestionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OptionService {
	
	private QuestionOptionRepository questionOptionRepository;
	private OptionMapper optionMapper;
	private QuestionRepository questionRepository;
	private AuthService authService;
	
	
	
	public QuestionOptionDto saveOption(QuestionOptionDto questionOptionDto) {
		questionOptionDto.setOptStatus("Approved");
		QuestionOption questionOption =  questionOptionRepository.save(optionMapper.dtoToOption(questionOptionDto, authService.getCurrentUser()));
		questionOptionDto.setOptId(questionOption.getOptId());
		return questionOptionDto;
	}


	public List<QuestionOptionDto> getOptionByQuestionId(Long id) {
		Question question = questionRepository.findById(id).orElseThrow(() -> new CellmaTrainingPortalException("getOptionByQuestionId Question not found with Id :" + id));
			return	questionOptionRepository.findQuestionOptionByoptQueId(question.getQueId()).stream().map(optionMapper::optionToDto).collect(toList());
	}

}
