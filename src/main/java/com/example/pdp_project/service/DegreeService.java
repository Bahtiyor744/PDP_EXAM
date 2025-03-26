package com.example.pdp_project.service;

import com.example.pdp_project.dto.*;
import com.example.pdp_project.entity.Answer;
import com.example.pdp_project.entity.Degree;
import com.example.pdp_project.entity.Question;
import com.example.pdp_project.enums.Level;
import com.example.pdp_project.repo.DegreeRepository;
import com.example.pdp_project.repo.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DegreeService {

    private final QuestionRepository questionRepository;
    private final DegreeRepository degreeRepository;

    public Object getRatingByCourseId(Integer courseId) {
        return degreeRepository.getRatingByCourseID(courseId);
    }

    public Object getRating(Integer currentUserId) {


        List<Object[]> rating = degreeRepository.getRating(currentUserId);
        return rating.stream()
                .map(obj -> new RatingDTO(
                        (Integer) obj[0],
                        (String) obj[1],
                        ((Number) obj[2]).intValue(),
                        ((Number) obj[3]).intValue()
                ))
                .collect(Collectors.toList());
    }

    public MarkDTO checkAnswers(UsersAnswerDTO usersAnswerDTO) {
        Degree degree = new Degree();
        Optional<Degree> presentDegree = degreeRepository.findByUserIdAndLessonId(usersAnswerDTO.getCurrentUserId(),
                usersAnswerDTO.getLessonId());
        presentDegree.ifPresent(value -> degree.setId(value.getId()));
        degree.setUserId(usersAnswerDTO.getCurrentUserId());
        degree.setLessonId(usersAnswerDTO.getLessonId());
        List<Question> questionList = questionRepository.findAllByLesson_Id(usersAnswerDTO.getLessonId());
        List<QuestionAndOneAnswerDTO> questionAndOneAnswerList = questionWithTrueAnswers(questionList);
        List<QuestionAndOneAnswerDTO> checkAnswers = usersAnswerDTO.getQuestionAndOneAnswer();
        int countCorrectAnswers = countCorrectAnswers(questionAndOneAnswerList, checkAnswers);
        degree.setMark(countCorrectAnswers);
        if (usersAnswerDTO.getStep().equals(Level.MEDIUM)) {
            degree.setMark(2 * countCorrectAnswers);
        } else if (usersAnswerDTO.getStep().equals(Level.HARD)) {
            degree.setMark(3 * countCorrectAnswers);
        }
        degreeRepository.save(degree);
        int wrong = Math.abs(checkAnswers.size() - countCorrectAnswers);
        return new MarkDTO(countCorrectAnswers, wrong, degree.getMark());
    }

    private int countCorrectAnswers(List<QuestionAndOneAnswerDTO> questionAndOneAnswerList, List<QuestionAndOneAnswerDTO> checkAnswers) {
        return (int) checkAnswers.stream()
                .filter(checkAnswer -> questionAndOneAnswerList.stream()
                        .anyMatch(correctAnswer ->
                                correctAnswer.getId().equals(checkAnswer.getId()) && // Совпадает ID вопроса
                                        correctAnswer.getAnswers().getId().equals(checkAnswer.getAnswers().getId()) // Совпадает ID ответа
                        )
                )
                .count();
    }

    private List<QuestionAndOneAnswerDTO> questionWithTrueAnswers(List<Question> allByLessonId) {
        return allByLessonId.stream()
                .map(question -> {
                    Answer correctAnswer = question.getAnswers().stream()
                            .filter(Answer::getCorrect)
                            .findFirst()
                            .orElse(null);

                    QuestionAndOneAnswerDTO dto = new QuestionAndOneAnswerDTO();
                    dto.setId(question.getId());
                    dto.setTitle(question.getTitle());
                    dto.setAnswers(correctAnswer != null ? new AnswerDTO(correctAnswer.getId(), correctAnswer.getTitle()) : null);

                    return dto;
                })
                .collect(Collectors.toList());
    }
}
