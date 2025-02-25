package com.example.pdp_project.entity;

import com.example.pdp_project.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class AttachmentContent extends BaseEntity {
    private Integer id;
    private byte[] content;
    @ManyToOne
    private Attachment attachment;
}
