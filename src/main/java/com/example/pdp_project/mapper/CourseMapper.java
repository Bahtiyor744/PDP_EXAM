package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.CourseDTO;
import com.example.pdp_project.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO toCourseMapDto(Course course);
    Course toCourseMap(CourseDTO dto);
}
