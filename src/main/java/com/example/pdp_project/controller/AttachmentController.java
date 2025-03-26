package com.example.pdp_project.controller;

import com.example.pdp_project.entity.Attachment;
import com.example.pdp_project.entity.AttachmentContent;
import com.example.pdp_project.repo.AttachmentContentRepository;
import com.example.pdp_project.repo.AttachmentRepository;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/file")
@RestController
@RequiredArgsConstructor
@MultipartConfig
public class AttachmentController {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;

    @PostMapping
    public Integer uploadFile(@RequestParam MultipartFile file) throws IOException {
        Attachment attachment = new Attachment(file.getOriginalFilename());
        attachmentRepository.save(attachment);
        AttachmentContent attachmentContent = new AttachmentContent(file.getBytes(), attachment);
        attachmentContentRepository.save(attachmentContent);
        return attachment.getId();
    }
    @GetMapping("/{attachmentId}")
    public void getFile(@PathVariable Integer attachmentId, HttpServletResponse response) throws IOException {
        AttachmentContent attachmentContent = attachmentContentRepository.findByAttachmentId(attachmentId);
        response.getOutputStream().write(attachmentContent.getContent());
    }


}
