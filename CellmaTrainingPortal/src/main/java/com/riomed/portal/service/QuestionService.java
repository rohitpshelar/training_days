package com.riomed.portal.service;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riomed.portal.dto.QuestionDto;
import com.riomed.portal.dto.QuestionOptionDto;
import com.riomed.portal.exceptions.ModuleNotFoundException;
import com.riomed.portal.mapper.QuestionMapper;
import com.riomed.portal.mapper.QuestionOptionMapper;
import com.riomed.portal.model.Module;
import com.riomed.portal.model.Question;
import com.riomed.portal.repository.ModuleRepository;
import com.riomed.portal.repository.QuestionOptionRepository;
import com.riomed.portal.repository.QuestionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService {

	private QuestionRepository questionRepository;
	private QuestionMapper questionMapper;
	
	private ModuleRepository moduleRepository;
	//private QuestionService questionService;
	
	private QuestionOptionRepository questionOptionRepository;
	private QuestionOptionMapper questionOptionMapper;
	private AuthService authService;

	public QuestionDto saveQuestion(QuestionDto questionDto) {
		questionDto.setQueStatus("Approved");
		Question question = questionRepository.save(questionMapper.dtoToQuestion(questionDto, authService.getCurrentUser()));
		questionDto.setQueId(question.getQueId());
		return questionDto;
	}

	public List<QuestionDto> getQuestionsByQueModId(Long queModId) {
		Module module = moduleRepository.findById(queModId)
				.orElseThrow(() -> new ModuleNotFoundException("queModId not found for " + queModId));
		return getQuestionByQueModId(module);
	}
	
	public List<QuestionDto> getQuestions( ) {
		return getAll();
	}

	@Transactional(readOnly = true)
	private List<QuestionDto> getAll() {
		List<QuestionDto> questionDtos =  questionRepository.findAll().stream().map(questionMapper::questionToDto).collect(toList());
		List<QuestionDto> questionDtoss = updateQuestions(questionDtos);
		return questionDtoss;
	}

	@Transactional(readOnly = true)
	public List<QuestionDto> getQuestionByQueModId(Module module) {
		List<Question> questionlist = questionRepository.findQuestionByQueModId(module.getModId());
		List<QuestionDto> questionDtos =  questionlist.stream().map(questionMapper::questionToDto).collect(toList());
		List<QuestionDto> questionDtoss = updateQuestions(questionDtos);
		return questionDtoss;
	}
	
	public List<QuestionDto>  updateQuestions(List<QuestionDto> questionDtos ) {
		List<QuestionDto> questionDtoss = new ArrayList<QuestionDto>();
		for (int i = 0; i < questionDtos.size(); i++) {
			QuestionDto questionDto = questionDtos.get(i);
			questionDto = mapOptionToQuestion(questionDto);
			questionDtoss.add(i, questionDto);
			
		}
		return questionDtoss;
	}
	
	@Transactional(readOnly = true)
	public QuestionDto mapOptionToQuestion(QuestionDto questionDto) {
		List<QuestionOptionDto> questionOptionDtos = questionOptionRepository.findQuestionOptionByoptQueId(questionDto.getQueId()).stream().map(questionOptionMapper::questionOptionToDto).collect(toList());
		 questionDto.setQuestionOptionDtos( questionOptionDtos);
		 return questionDto;
	}

}
