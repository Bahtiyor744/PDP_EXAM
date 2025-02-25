package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.UserDTO;
import com.example.pdp_project.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserMapDto(User user);
    User toUserMap(UserDTO dto);
}
