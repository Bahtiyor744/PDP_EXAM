package com.example.pdp_project.service;


import com.example.pdp_project.dto.LessonDto;
import com.example.pdp_project.dto.ModuleDTO;
import com.example.pdp_project.entity.Lesson;
import com.example.pdp_project.entity.Module;
import com.example.pdp_project.mapper.LessonMapper;
import com.example.pdp_project.repo.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper=LessonMapper.INSTANCE;

    public List<LessonDto> getLessonsByModuleId(Integer id){
        List<LessonDto> lessonDto=new ArrayList<>();
        for (Lesson lesson : lessonRepository.findAllByModule_Id(id)) {
            LessonDto lessonDtoMapDto = lessonMapper.toLessonDtoMapDto(lesson);
            lessonDto.add(lessonDtoMapDto);
        }
        return lessonDto;
    }

    public List<LessonDto> getAllLessons(){

        List<Lesson> all = lessonRepository.findAll();
        List<LessonDto> lessonDto=new ArrayList<>();
        for (Lesson lesson : all) {
            LessonDto lessonDtoMapDto = lessonMapper.toLessonDtoMapDto(lesson);
            lessonDto.add(lessonDtoMapDto);
        }
        return lessonDto;

    }

    public LessonDto getLessonById(Integer id) {
        Optional<Lesson> byId = lessonRepository.findById(id);
        return byId.map(lessonMapper::toLessonDtoMapDto).orElse(null);
    }

    public LessonDto createLesson(LessonDto lessonDto) {
        Lesson lessonMap = lessonMapper.toLessonMap(lessonDto);
        lessonRepository.save(lessonMap);
        return lessonDto;
    }

    public LessonDto updateLesson(Integer id, LessonDto lessonDto) {
        if (lessonRepository.existsById(id)) {
            Lesson lesson = lessonMapper.toLessonMap(lessonDto);
            lessonRepository.save(lesson);
            return lessonDto;
        }
        return null;
    }

    public void deleteLesson(Integer id) {
        lessonRepository.deleteById(id);

    }

}
