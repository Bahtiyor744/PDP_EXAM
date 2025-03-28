package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.RegisterDTO;
import com.example.pdp_project.dto.UserDTO;
import com.example.pdp_project.dto.UserUpdateDTO;
import com.example.pdp_project.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserMapDto(User user);
    User toUserMap(UserDTO dto);
    User toUserMap(RegisterDTO dto);
    User toUserMap(UserUpdateDTO dto);
}
