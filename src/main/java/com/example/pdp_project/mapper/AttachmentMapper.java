package com.example.pdp_project.mapper;

import com.example.pdp_project.dto.AttachmentDTO;
import com.example.pdp_project.entity.Attachment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AttachmentMapper {
    AttachmentMapper INSTANCE = Mappers.getMapper(AttachmentMapper.class);

    Attachment attachmentMap(AttachmentDTO dto);
    AttachmentDTO attachmentMapDto(Attachment attachment);
}
