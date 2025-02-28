package com.example.pdp_project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor()
public class UserDTO {
    private Integer id;
    private String username;
    private String email;
    private Integer roleId;
}