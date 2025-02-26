package com.example.pdp_project.controller;

import com.example.pdp_project.dto.CourseDTO;
import com.example.pdp_project.entity.Course;
import com.example.pdp_project.mapper.CourseMapper;
import com.example.pdp_project.repo.CourseRepository;
import com.example.pdp_project.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public HttpEntity<?> getCourse() {
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/id")
    public HttpEntity<?> getCourseById(@RequestParam("id") Integer id) {
        CourseDTO courseById = courseService.getCourseById(id);
        return ResponseEntity.ok(courseById);
    }

    @PostMapping
    public HttpEntity<?> addCourse(@RequestBody CourseDTO courseDTO) {
        CourseDTO course = courseService.createCourse(courseDTO);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCourseById(@PathVariable("id") Integer id) {
       courseService.deleteCourse(id);
       return ResponseEntity.noContent().build();
    }

}
