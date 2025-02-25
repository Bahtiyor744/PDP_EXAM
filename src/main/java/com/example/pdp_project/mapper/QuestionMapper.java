package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.QuestionDTO;
import com.example.pdp_project.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionDTO questionMapDto(Question question);
    Question questionMap(QuestionDTO dto);
}
