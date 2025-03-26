package com.example.pdp_project.mapper;


import com.example.pdp_project.dto.LessonDto;
import com.example.pdp_project.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    @Mapping(source = "module.id" , target = "moduleId")
    LessonDto toLessonDtoMapDto(Lesson lesson);
    Lesson toLessonMap(LessonDto lessonDto);
}
