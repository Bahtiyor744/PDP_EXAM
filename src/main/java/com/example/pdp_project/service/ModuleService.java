package com.example.pdp_project.service;

import com.example.pdp_project.dto.ModuleDTO;
import com.example.pdp_project.entity.Module;
import com.example.pdp_project.mapper.ModuleMapper;
import com.example.pdp_project.repo.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleService {

    private final ModuleRepository moduleRepository;
    private final ModuleMapper moduleMapper=ModuleMapper.INSTANCE;

    public List<ModuleDTO> getAllModules() {
        List<Module> modules=moduleRepository.findAll();
        return modules.stream()
                .map(moduleMapper::toModuleMapDto)
                .collect(Collectors.toList());

    }

    public ModuleDTO getModuleById(Integer id) {
        Optional<Module> module=moduleRepository.findById(id);
        return module.map(moduleMapper::toModuleMapDto).orElse(null);
    }

    public ModuleDTO createModule(ModuleDTO moduleDTO) {
        Module module=moduleMapper.toModuleMap(moduleDTO);
        module=moduleRepository.save(module);
        return moduleMapper.toModuleMapDto(module);
    }

    public ModuleDTO updateModule(Integer id, ModuleDTO moduleDTO) {
        if(moduleRepository.existsById(id)) {
            Module module=moduleMapper.toModuleMap(moduleDTO);
            module=moduleRepository.save(module);
            module.setId(id);
            return moduleMapper.toModuleMapDto(module);
        }
        return null;
    }

    public void deleteModule(Integer id) {
        moduleRepository.deleteById(id);

    }
}
