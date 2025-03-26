package com.example.pdp_project.repo;

import com.example.pdp_project.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {
  AttachmentContent findByAttachmentId(Integer attachmentId);
}