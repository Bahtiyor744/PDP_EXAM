package com.example.pdp_project.service;

import com.example.pdp_project.dto.AttachmentContentDTO;
import com.example.pdp_project.dto.AttachmentDTO;
import com.example.pdp_project.entity.Attachment;
import com.example.pdp_project.entity.AttachmentContent;
import com.example.pdp_project.mapper.AttachmentContentMapper;
import com.example.pdp_project.mapper.AttachmentMapper;
import com.example.pdp_project.repo.AttachmentContentRepository;
import com.example.pdp_project.repo.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttachmentContentService {

    private final AttachmentContentRepository attachmentContentRepository;
    private final AttachmentContentMapper attachmentMapper=AttachmentContentMapper.INSTANCE;


    public List<AttachmentContentDTO> getAllAttachments() {
        List<AttachmentContent> attachments=attachmentContentRepository.findAll();
        return attachments.stream()
                .map(attachmentMapper::toAttachmentMapDto)
                .collect(Collectors.toList());
    }
    public AttachmentContentDTO getAttachmentById(Integer id) {
        Optional<AttachmentContent> attachment=attachmentContentRepository.findById(id);
        return attachment.map(attachmentMapper::toAttachmentMapDto).orElse(null);

    }

    public AttachmentContentDTO createAttachment(AttachmentContentDTO attachmentContentDTO) {
        AttachmentContent attachmentContent=attachmentMapper.toAttachmentMap(attachmentContentDTO);
        attachmentContent=attachmentContentRepository.save(attachmentContent);
        return attachmentMapper.toAttachmentMapDto(attachmentContent);
    }

    public AttachmentContentDTO updateAttachment(Integer id, AttachmentContentDTO attachmentContentDTO) {
        if(attachmentContentRepository.existsById(id)) {
            AttachmentContent attachmentContent=attachmentContentRepository.findById(id).get();
            attachmentContent.setId(id);
            attachmentContent=attachmentContentRepository.save(attachmentContent);
            return attachmentMapper.toAttachmentMapDto(attachmentContent);
        }

        return null;
    }

    public void deleteAttachment(Integer id) {
        attachmentContentRepository.deleteById(id);
    }



}