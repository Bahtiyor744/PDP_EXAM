package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.AnswerDTO;
import com.example.pdp_project.dto.QuestionDTO;
import com.example.pdp_project.entity.Answer;
import com.example.pdp_project.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(source = "lesson.id", target = "lessonId")
    @Mapping(source = "answers", target = "answersDTO")
    QuestionDTO toQuestionMapDto(Question question);


    Question toQuestionMap(QuestionDTO dto);
}
