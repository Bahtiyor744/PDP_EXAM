package com.example.pdp_project.dto;

import com.example.pdp_project.entity.Attachment;
import com.example.pdp_project.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor()
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Roles> roles;
    private Attachment attachment;
}