package com.example.pdp_project.dto;

import lombok.Value;

@Value
public class AttachmentContentDTO {
    private Integer id;
    private byte[] data;
    private Integer attachmentId;
}
