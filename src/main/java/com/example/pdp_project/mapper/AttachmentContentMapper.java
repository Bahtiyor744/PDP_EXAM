package com.example.pdp_project.mapper;


import com.example.pdp_project.dto.AttachmentContentDTO;
import com.example.pdp_project.entity.AttachmentContent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttachmentContentMapper {
    AttachmentContentMapper INSTANCE = Mappers.getMapper(AttachmentContentMapper.class);

    AttachmentContent attachmentMap(AttachmentContentDTO dto);
    AttachmentContentDTO attachmentMapDto(AttachmentContent attachment);
}
