package com.example.pdp_project.service;

import com.example.pdp_project.dto.QuestionDTO;
import com.example.pdp_project.entity.Question;
import com.example.pdp_project.mapper.QuestionMapper;
import com.example.pdp_project.repo.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper=QuestionMapper.INSTANCE;

    public List<QuestionDTO> getAllQuestions() {
        List<Question> questions=questionRepository.findAll();
        return questions.stream()
                .map(questionMapper::toQuestionMapDto)
                .collect(Collectors.toList());
    }

    public QuestionDTO getQuestionById(Integer id) {
        Optional<Question> question=questionRepository.findById(id);
        return question.map(questionMapper::toQuestionMapDto).orElse(null);
    }

    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
        Question question=questionMapper.toQuestionMap(questionDTO);
        questionRepository.save(question);
        return questionMapper.toQuestionMapDto(question);
    }

    public QuestionDTO updateQuestion(Integer id, QuestionDTO questionDTO) {
        if(questionRepository.existsById(id)) {
            Question question=questionRepository.findById(id).get();
            question.setId(id);
            questionRepository.save(question);
            return questionMapper.toQuestionMapDto(question);
        }
        return null;
    }

    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }
}
