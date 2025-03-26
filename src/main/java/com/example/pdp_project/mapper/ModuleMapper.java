package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.ModuleDTO;
import com.example.pdp_project.dto.ModulePostDTO;
import com.example.pdp_project.entity.Module;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModuleMapper {
    ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);

    @Mapping(source = "course.id", target = "courseId")
    ModuleDTO toModuleMapDto(Module module);
    Module toModuleMap(ModulePostDTO dto);
    List<ModuleDTO> toDtoList(List<Module> modules);

}
