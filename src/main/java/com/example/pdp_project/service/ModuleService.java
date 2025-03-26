package com.example.pdp_project.service;

import com.example.pdp_project.dto.ModuleDTO;
import com.example.pdp_project.dto.ModulePostDTO;
import com.example.pdp_project.entity.Course;
import com.example.pdp_project.entity.Module;
import com.example.pdp_project.mapper.ModuleMapper;
import com.example.pdp_project.repo.CourseRepository;
import com.example.pdp_project.repo.ModuleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper = ModuleMapper.INSTANCE;
    private final CourseRepository courseRepository;

    public List<ModuleDTO> getAllModules() {
        List<Module> modules = moduleRepository.findAll();
        return modules.stream().map(moduleMapper::toModuleMapDto).toList();
    }

    public List<?> getModulesByCourseId(Integer id) {
        return moduleMapper.toDtoList(moduleRepository.findAllByCourse_Id(id));
    }

    public ModuleDTO getModuleById(Integer id) {
        return moduleRepository.findById(id).map(moduleMapper::toModuleMapDto).orElse(null);
    }

    public ModuleDTO createModule(@Valid ModulePostDTO moduleDTO) {
        Module module = moduleMapper.toModuleMap(moduleDTO);
        return moduleMapper.toModuleMapDto(moduleRepository.save(module));
    }

    public ModuleDTO updateModule(ModuleDTO moduleDTO) {
        Course course = courseRepository.findById(moduleDTO.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course with ID " + moduleDTO.getCourseId() + " not found"));
        Module module = moduleRepository.findById(moduleDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Module with ID " + moduleDTO.getId() + " not found"));
        module.setName(module.getName());
        module.setCourse(course);
        return moduleMapper.toModuleMapDto(moduleRepository.save(module));
    }

    public void deleteModule(Integer id) {
        if (!moduleRepository.existsById(id)) {
            throw new EntityNotFoundException("Module with ID " + id + " not found");
        }
        moduleRepository.deleteById(id);
    }
}
