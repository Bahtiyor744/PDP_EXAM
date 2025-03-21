package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.ModuleDTO;
import com.example.pdp_project.entity.Module;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ModuleMapper {
    ModuleMapper INSTANCE = Mappers.getMapper(ModuleMapper.class);

    ModuleDTO toModuleMapDto(Module module);
    Module toModuleMap(ModuleDTO dto);


}
