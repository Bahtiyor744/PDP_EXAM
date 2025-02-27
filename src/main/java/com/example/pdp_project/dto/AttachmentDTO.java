package com.example.pdp_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class AttachmentDTO {
    private Integer id;
    private String fileName;
    private String fileType;
}

