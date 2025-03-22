package com.example.pdp_project.service;

import com.example.pdp_project.dto.AnswerDTO;
import com.example.pdp_project.entity.Answer;
import com.example.pdp_project.mapper.AnswerMapper;
import com.example.pdp_project.repo.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper=AnswerMapper.INSTANCE;

    public List<AnswerDTO> getAllAnswers() {
        List<Answer> answers=answerRepository.findAll();
        return answers.stream()
                .map(answerMapper::toAnswermapDto)
                .collect(Collectors.toList());
    }

    public AnswerDTO getAnswerById(int id) {
        Optional<Answer> answer=answerRepository.findById(id);
        return  answer.map(answerMapper::toAnswermapDto).orElse(null);
    }

    public AnswerDTO createAnswer(AnswerDTO answerDTO) {
       Answer answer=answerMapper.toAnswerMap(answerDTO);
       Answer savedAnswer=answerRepository.save(answer);
       return answerMapper.toAnswermapDto(savedAnswer);
    }

//    public AnswerDTO updateAnswer(int id, AnswerDTO answerDTO) {
//
//        if(answerRepository.existsById(id)) {
//            Answer answer=answerMapper.toAnswerMap(answerDTO);
//            Answer savedAnswer=answerRepository.save(answer);
//            answer.setId(id);
//            return answerMapper.toAnswermapDto(savedAnswer);
//        }
//        return null;
//    }

    public void deleteAnswer(int id) {
        if(answerRepository.existsById(id)) {
            Answer answer=answerRepository.findById(id).orElse(null);
            assert answer != null;
            answerRepository.delete(answer);
        }
    }

//    public List<AnswerDTO> getAnswerByQuestionsId(Integer id) {
//        List<Answer> allByQuestionId = answerRepository.findAllByQuestion_Id(id);
//        List<AnswerDTO> answerDTOS=new ArrayList<>();
//        for (Answer answer : allByQuestionId) {
//            answerDTOS.add(answerMapper.toAnswermapDto(answer));
//        }
//        return answerDTOS;
//    }
}
