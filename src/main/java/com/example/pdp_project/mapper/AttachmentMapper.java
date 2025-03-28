package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.AttachmentDTO;
import com.example.pdp_project.entity.Attachment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AttachmentMapper {
    AttachmentMapper INSTANCE = Mappers.getMapper(AttachmentMapper.class);

    Attachment toAttachmentMap(AttachmentDTO dto);
    AttachmentDTO toAttachmentMapDto(Attachment attachment);
}
