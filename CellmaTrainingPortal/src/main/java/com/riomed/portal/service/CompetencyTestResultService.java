package com.riomed.portal.service;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.riomed.portal.dto.CompetencyTestResultDto;
import com.riomed.portal.dto.QuestionDto;
import com.riomed.portal.dto.QuestionOptionDto;
import com.riomed.portal.exceptions.CellmaTrainingPortalException;
import com.riomed.portal.mapper.CompetencyTestResultMapper;
import com.riomed.portal.mapper.QuestionMapper;
import com.riomed.portal.model.CompetencyTestAnswer;
import com.riomed.portal.model.CompetencyTestResult;
import com.riomed.portal.model.Module;
import com.riomed.portal.model.Question;
import com.riomed.portal.model.User;
import com.riomed.portal.repository.CompetencyTestAnswerRepository;
import com.riomed.portal.repository.CompetencyTestResultReposiroty;
import com.riomed.portal.repository.ModuleRepository;
import com.riomed.portal.repository.QuestionOptionRepository;
import com.riomed.portal.repository.QuestionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompetencyTestResultService {
	
	private CompetencyTestResultReposiroty competencyTestResultReposiroty;
	private CompetencyTestResultMapper competencyTestResultMapper;
	private AuthService authService;
	private ModuleRepository moduleRepository;
	private QuestionService  questionService;
	private CompetencyTestAnswerRepository competencyTestAnswerRepository;
	private QuestionRepository questionRepository;
	private QuestionMapper questionMapper;
	private QuestionOptionRepository questionOptionRepository;
	
	@Transactional
	public CompetencyTestResultDto saveCompetencyTestResult(CompetencyTestResultDto competencyTestResultDto, String user) {
		Module module = new Module();
		if(competencyTestResultDto.getCtrModCode() != null && !competencyTestResultDto.getCtrModCode().isBlank()) {
		 module=  	moduleRepository.findByModCode(competencyTestResultDto.getCtrModCode());//.orElseThrow(() -> new CellmaTrainingPortalException("Module not found"));
		}else if(competencyTestResultDto.getCtrModId() != null && !competencyTestResultDto.getCtrModId().toString().isBlank()) {
		 module=  	moduleRepository.findById(1L).orElseThrow(() -> new CellmaTrainingPortalException("Module not found"));
		}else {
			new CellmaTrainingPortalException("Module not found");
			return null;
		}
		
		competencyTestResultDto.setCtrModCode(module.getModCode());
		competencyTestResultDto.setCtrModId(module.getModId());
		competencyTestResultDto.setCtrModQuestionLimit(module.getModQuestionLimit());
		competencyTestResultDto.setCtrResult("Attended");
		
		CompetencyTestResult competencyTestResult = competencyTestResultReposiroty.save(competencyTestResultMapper.DtoToCompetencyTestResult(competencyTestResultDto, user));
		competencyTestResultDto.setCtrId(competencyTestResult.getCtrId());
		
		List<Integer> queList = generateQuestionSetAsPerModuleQuestionLimit( module,  user,  competencyTestResult);
		
		List<Long> longs = queList.stream()
		        .mapToLong(Integer::longValue)
		        .boxed().collect(Collectors.toList());
		
		Iterable<Long> queLterable = longs;
		List<Question> questions =   questionRepository.findAllById(queLterable);
		List<QuestionDto> questionDtos =  questions.stream().map(questionMapper::questionToDto).collect(toList());
		if(module.isModRandomQuestions()) {
			shuffleObject(questionDtos);
		}
		List<QuestionDto> questionDtoss = questionService.updateQuestions(questionDtos, module.isModRandomQuestions());
		competencyTestResultDto.setQuestionDtos(questionDtoss);
		
		return competencyTestResultDto;
	
	}
	
	public static<T> List<T> shuffleObject(List<T> list)
	{
		Random random = new Random();
		int n = list.size();

		// start from beginning of the list
		for (int i = 0; i < n - 1; i++)
		{
			// get a random index j such that i <= j <= n
			int j = i + random.nextInt(n - i);

			// swap element at i'th position in the list with element at
			// randomly generated index j
			T obj = list.get(i);
			list.set(i, list.get(j));
			list.set(j, obj);
		}
		return list;
	}

	
	@Transactional
	public CompetencyTestResultDto saveCompetencyTestResult(CompetencyTestResultDto competencyTestResultDto) {
		Module module = new Module();
		if(competencyTestResultDto.getCtrModCode() != null && !competencyTestResultDto.getCtrModCode().isBlank()) {
		 module=  	moduleRepository.findByModCode(competencyTestResultDto.getCtrModCode());//.orElseThrow(() -> new CellmaTrainingPortalException("Module not found"));
		}else if(competencyTestResultDto.getCtrModId() != null && !competencyTestResultDto.getCtrModId().toString().isBlank()) {
		 module=  	moduleRepository.findById(1L).orElseThrow(() -> new CellmaTrainingPortalException("Module not found"));
		}else {
			new CellmaTrainingPortalException("Module not found");
			return null;
		}
		
		competencyTestResultDto.setCtrModCode(module.getModCode());
		competencyTestResultDto.setCtrModId(module.getModId());
		competencyTestResultDto.setCtrModQuestionLimit(module.getModQuestionLimit());
		competencyTestResultDto.setCtrResult("Attended");
		
		CompetencyTestResult competencyTestResult = competencyTestResultReposiroty.save(competencyTestResultMapper.DtoToCompetencyTestResult(competencyTestResultDto, authService.getCurrentUser()));
		competencyTestResultDto.setCtrId(competencyTestResult.getCtrId());
		
		List<Integer> queList = generateQuestionSetAsPerModuleQuestionLimit( module,  authService.getCurrentUser(),  competencyTestResult);
		
		List<Long> longs = queList.stream()
		        .mapToLong(Integer::longValue)
		        .boxed().collect(Collectors.toList());
		
		Iterable<Long> queLterable = longs;
		List<Question> questions =   questionRepository.findAllById(queLterable);
		if(module.isModRandomQuestions()) {
			shuffleObject(questions);
		}
		List<QuestionDto> questionDtos =  questions.stream().map(questionMapper::questionToDto).collect(toList());
		List<QuestionDto> questionDtoss = questionService.updateQuestions(questionDtos, module.isModRandomQuestions());
		competencyTestResultDto.setQuestionDtos(questionDtoss);
		
		return competencyTestResultDto;
	
	}
	private List<Integer> generateQuestionSetAsPerModuleQuestionLimit(Module module, String user, CompetencyTestResult competencyTestResult) {
		
		List<QuestionDto> questions = questionService.getQuestionByQueModId(module);
	//	List<QuestionDto> mendatoryList = questions.stream().filter(p -> p.isQueMandatory()).collect(Collectors.toList());
		List<Integer> mendatoryList = new ArrayList<Integer>();
		List<Integer> disabledQuestionList = new ArrayList<Integer>();
		for (QuestionDto questionDto : questions) {
			if(questionDto.isQueMandatory()) {
				mendatoryList.add(questionDto.getQueId().intValue());
			}
			if(questionDto.getQueStatus().equals("Disable")) {
				disabledQuestionList.add(questionDto.getQueId().intValue());
			}
			
		}
		
		List<Integer> questionList= generateQuestionSetFromList(module.getModQuestionLimit().intValue(), questions, mendatoryList, module.isModRandomQuestions(), disabledQuestionList);
		
		for (Integer QueIds : questionList) {
			CompetencyTestAnswer testAnswer = new CompetencyTestAnswer();
			testAnswer.setCtaModId(module.getModId());
			testAnswer.setCtaQueId(Long.valueOf(QueIds));
			testAnswer.setCtaOptWeighting(0L);
			testAnswer.setCtaCtrId(competencyTestResult.getCtrId());
			testAnswer.setCtaUseUsername(user);
			competencyTestAnswerRepository.save(testAnswer);
		}
		
		return questionList;
	}
	
	private List<Integer> generateQuestionSetAsPerModuleQuestionLimit(Module module, User user, CompetencyTestResult competencyTestResult) {
		
		List<QuestionDto> questions = questionService.getQuestionByQueModId(module);
	//	List<QuestionDto> mendatoryList = questions.stream().filter(p -> p.isQueMandatory()).collect(Collectors.toList());
		List<Integer> mendatoryList = new ArrayList<Integer>();
		List<Integer> disabledQuestionList = new ArrayList<Integer>();
		for (QuestionDto questionDto : questions) {
			if(questionDto.isQueMandatory()) {
				mendatoryList.add(questionDto.getQueId().intValue());
			}
			if(questionDto.getQueStatus().equals("Disable")) {
				disabledQuestionList.add(questionDto.getQueId().intValue());
			}
			
		}
		
		List<Integer> questionList= generateQuestionSetFromList(module.getModQuestionLimit().intValue(), questions, mendatoryList, module.isModRandomQuestions(), disabledQuestionList);
		
		for (Integer QueIds : questionList) {
			CompetencyTestAnswer testAnswer = new CompetencyTestAnswer();
			testAnswer.setCtaModId(module.getModId());
			testAnswer.setCtaQueId(Long.valueOf(QueIds));
			testAnswer.setCtaOptWeighting(0L);
			testAnswer.setCtaCtrId(competencyTestResult.getCtrId());
			testAnswer.setCtaUseUsername(authService.getCurrentUser().getUsername());
			competencyTestAnswerRepository.save(testAnswer);
		}
		
		return questionList;
	}
	
	private static List<Integer> generateQuestionSetFromList(Integer modQuestionLimit, List<QuestionDto> totalQue, List<Integer> mendatoryList, boolean modRandomQuestions, List<Integer> disabledQuestionList ) {
		
		if(modQuestionLimit == 0) {
			modQuestionLimit = totalQue.size();
		}
		
		for (int i = modQuestionLimit; 0 < i; i--) {
			System.out.println(i);
			Integer No = totalQue.get(0).getQueId().intValue();
			if (mendatoryList.contains(No)) {
				totalQue.remove(0);
			} else {
				if(!disabledQuestionList.contains(No)) {
				mendatoryList.add(No);
				totalQue.remove(0);
				}else {
					totalQue.remove(0);
					i--;
				}
			}
			
		}
		return mendatoryList;
	}

	public CompetencyTestResultDto submitCompetencyTestResult(CompetencyTestResultDto competencyTestResultDto) {
		double countRightAns = 0;
		double countQuestions = 0;
		
		Module module = moduleRepository.getOne(competencyTestResultDto.getCtrModId());
		
		List<QuestionDto> questionDtos = competencyTestResultDto.getQuestionDtos();
		for (QuestionDto questionDto : questionDtos) {
			
			CompetencyTestAnswer competencyTestAnswer = competencyTestAnswerRepository.findByCtaModIdAndCtaQueIdAndCtaCtrId(competencyTestResultDto.getCtrModId(), questionDto.getQueId(), competencyTestResultDto.getCtrId());
			for (QuestionOptionDto optionDto : questionDto.getQuestionOptionDtos()) {
				if(optionDto.isSelected()) {
					competencyTestAnswer.setCtaOptId(optionDto.getOptId());
					Long OptWeighting = questionOptionRepository.getOne(optionDto.getOptId()).getOptWeighting();
					competencyTestAnswer.setCtaOptWeighting(OptWeighting);
					competencyTestAnswerRepository.save(competencyTestAnswer);
					if(OptWeighting.equals(1L)) {
						countRightAns = countRightAns+1;
					}
				}
			}
			countQuestions = countQuestions +1;
		}
		
		CompetencyTestResult competencyTestResult = competencyTestResultReposiroty.getOne(competencyTestResultDto.getCtrId());
		Long calculatedPercentage = (long) ((countRightAns/countQuestions)*100);
		competencyTestResult.setCtrPercentageScore(calculatedPercentage);
		competencyTestResultDto.setCtrPercentageScore(calculatedPercentage);
		if(module.getModWeightingPassPercent()<=calculatedPercentage) {
			competencyTestResult.setCtrResult("PASSED");
			competencyTestResultDto.setCtrResult("PASSED");
		}else {
			competencyTestResult.setCtrResult("FAILED");
			competencyTestResultDto.setCtrResult("FAILED");
		}
		// TODO We can Add submited timestamp and also Duration (Mins)
		competencyTestResultReposiroty.save(competencyTestResult);
		
		return competencyTestResultDto;
	}
	

}
