package com.example.pdp_project.service;

import com.example.pdp_project.dto.CourseDTO;
import com.example.pdp_project.dto.CoursePostDTO;
import com.example.pdp_project.entity.Course;
import com.example.pdp_project.mapper.CourseMapper;
import com.example.pdp_project.repo.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper = CourseMapper.INSTANCE;

    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toCourseMapDto)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.map(courseMapper::toCourseMapDto).
                orElseThrow(() -> new EntityNotFoundException("Course with ID " + id + " not found"));
    }

    public CourseDTO createCourse(@Valid CoursePostDTO courseDTO) {
        Course course = courseMapper.toCourseMap(courseDTO);
        return courseMapper.toCourseMapDto(courseRepository.save(course));
    }

    public CourseDTO updateCourse(CourseDTO courseDTO) {
        Course course = courseRepository.findById(courseDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Course with ID " + courseDTO.getId() + " not found"));
        course.setName(courseDTO.getName());
        return courseMapper.toCourseMapDto(courseRepository.save(course));
    }

    public void deleteCourse(Integer id) {
        if (!courseRepository.existsById(id)) {
            throw new EntityNotFoundException("Course with ID " + id + " not found");
        }
        courseRepository.deleteById(id);
    }
}
