package com.example.pdp_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private byte[] content;
    @ManyToOne
    private Attachment attachment;
}
