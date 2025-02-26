package com.example.pdp_project.service;

import com.example.pdp_project.dto.AttachmentDTO;
import com.example.pdp_project.entity.Attachment;
import com.example.pdp_project.mapper.AttachmentMapper;
import com.example.pdp_project.repo.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper=AttachmentMapper.INSTANCE;

    public List<AttachmentDTO> getAllAttachments() {
        List<Attachment> attachments=attachmentRepository.findAll();
        return attachments.stream()
                .map(attachmentMapper::toAttachmentMapDto)
                .collect(Collectors.toList());
    }

    public AttachmentDTO getAttachmentById(Integer id) {
        Optional<Attachment> attachment=attachmentRepository.findById(id);
        return attachment.map(attachmentMapper::toAttachmentMapDto).orElse(null);

    }

    public AttachmentDTO createAttachment(AttachmentDTO attachmentDTO) {
        Attachment attachment=attachmentMapper.toAttachmentMap(attachmentDTO);
        attachmentRepository.save(attachment);
        return attachmentMapper.toAttachmentMapDto(attachment);
    }
    public AttachmentDTO updateAttachmentById(Integer id, AttachmentDTO attachmentDTO) {
        if (attachmentRepository.findById(id).isPresent()) {
            Attachment attachment=attachmentRepository.findById(id).get();
            attachment.setId(id);
            return attachmentMapper.toAttachmentMapDto(attachmentRepository.save(attachment));
        }
        return null;
    }
    public void deleteAttachmentById(Integer id) {
        attachmentRepository.deleteById(id);
    }

}
