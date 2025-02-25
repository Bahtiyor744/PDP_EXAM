package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.AnswerDTO;
import com.example.pdp_project.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerDTO answermapDto(Answer answer);
    Answer answerMap(AnswerDTO dto);
}
