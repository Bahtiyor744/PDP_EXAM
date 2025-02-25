package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.RolesDTO;
import com.example.pdp_project.entity.Roles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RolesMapper {
    RolesMapper INSTANCE = Mappers.getMapper(RolesMapper.class);

    RolesDTO toRolesMapper(Roles roles);
    Roles toRolesMapper(RolesDTO dto);
}
