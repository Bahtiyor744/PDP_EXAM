package com.example.pdp_project.service;

import com.example.pdp_project.dto.CourseDTO;
import com.example.pdp_project.entity.Course;
import com.example.pdp_project.mapper.CourseMapper;
import com.example.pdp_project.repo.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper=CourseMapper.INSTANCE;

    public List<CourseDTO> getAllCourses() {
        List<Course> courses=courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toCourseMapDto)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Integer id) {
        Optional<Course> course=courseRepository.findById(id);
             return course.map(courseMapper::toCourseMapDto).orElse(null);
    }

    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course=courseMapper.toCourseMap(courseDTO);
        course=courseRepository.save(course);
        return courseMapper.toCourseMapDto(course);
    }

    public CourseDTO updateCourse(Integer id, CourseDTO courseDTO) {
        if(courseRepository.existsById(id)) {
            Course course=courseRepository.findById(id).get();
            course.setId(id);
            courseRepository.save(course);
            return courseMapper.toCourseMapDto(course);
        }
        return null;
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
