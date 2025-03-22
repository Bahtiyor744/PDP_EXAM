package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.RolesDTO;
import com.example.pdp_project.entity.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RolesMapper {
    RolesMapper INSTANCE = Mappers.getMapper(RolesMapper.class);

    RolesDTO toRolesMapperDto(Roles roles);
    Roles toRolesMapper(RolesDTO dto);
}
