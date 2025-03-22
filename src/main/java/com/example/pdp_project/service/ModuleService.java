package com.example.pdp_project.service;

import com.example.pdp_project.dto.ModuleDTO;
import com.example.pdp_project.entity.Module;
import com.example.pdp_project.mapper.ModuleMapper;
import com.example.pdp_project.repo.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper = ModuleMapper.INSTANCE;

    public List<Module> getAllModules() {
        List<Module> modules = moduleRepository.findAll();
//        System.out.println(modules.get(1).getName());
//        System.out.println(modules.get(1).getCourse());
//        System.out.println(modules.get(1).getId());
//        System.out.println(modules.get(1).getLessons());
//        return modules.stream()
//                .map(moduleMapper::toModuleMapDto)
//                .collect(Collectors.toList());
        return modules;

    }

    public ModuleDTO getModuleById(Integer id) {
        Optional<Module> module = moduleRepository.findById(id);
        return module.map(moduleMapper::toModuleMapDto).orElse(null);
    }

    public ModuleDTO createModule(ModuleDTO moduleDTO) {
        Module module = moduleMapper.toModuleMap(moduleDTO);
        module = moduleRepository.save(module);
        return moduleMapper.toModuleMapDto(module);
    }

    public ModuleDTO updateModule(Integer id, ModuleDTO moduleDTO) {
        if (moduleRepository.existsById(id)) {
            Module module = moduleMapper.toModuleMap(moduleDTO);
            module = moduleRepository.save(module);
            module.setId(id);
            return moduleMapper.toModuleMapDto(module);
        }
        return null;
    }

    public void deleteModule(Integer id) {
        moduleRepository.deleteById(id);

    }

    public List<ModuleDTO> getModulesByCourseId(Integer id) {
        List<Module> allByCourseId = moduleRepository.findAllByCourse_Id(id);
        List<ModuleDTO> moduleDTOList=new ArrayList<>();
        for (Module module : allByCourseId) {
            ModuleDTO moduleMapDto = moduleMapper.toModuleMapDto(module);
            moduleDTOList.add(moduleMapDto);
        }
        return moduleDTOList;
    }
}
