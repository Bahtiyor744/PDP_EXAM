package com.example.pdp_project.dto;

import lombok.Value;

@Value
public class UserDTO {
    private Integer id;
    private String username;
    private String email;
    private Integer roleId;
}