package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.DegreeDto;
import com.example.pdp_project.entity.Degree;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DegreeMapper {

    DegreeMapper INSTANCE = Mappers.getMapper(DegreeMapper.class);

    DegreeDto toDegreeMapDto(Degree degree);
    Degree toDegreeMap(DegreeDto dto);



}
