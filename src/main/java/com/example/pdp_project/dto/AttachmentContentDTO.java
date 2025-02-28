package com.example.pdp_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor()
public class AttachmentContentDTO {
    private Integer id;
    private byte[] data;
    private Integer attachmentId;
}
