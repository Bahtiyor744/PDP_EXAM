package com.example.pdp_project.mapper;


import com.example.pdp_project.dto.AttachmentContentDTO;
import com.example.pdp_project.entity.AttachmentContent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AttachmentContentMapper {
    AttachmentContentMapper INSTANCE = Mappers.getMapper(AttachmentContentMapper.class);

    AttachmentContent toAttachmentMap(AttachmentContentDTO dto);
    AttachmentContentDTO toAttachmentMapDto(AttachmentContent attachment);
}
