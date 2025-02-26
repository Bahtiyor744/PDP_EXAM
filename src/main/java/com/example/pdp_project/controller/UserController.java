package com.example.pdp_project.controller;

import com.example.pdp_project.dto.UserDTO;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.mapper.UserMapper;
import com.example.pdp_project.repo.UserRepository;
import com.example.pdp_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping
    public HttpEntity<?> getUsers() {
        List<UserDTO> userDTOS = userService.findAll();
        return ResponseEntity.ok(userDTOS);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getUser(@PathVariable("id") Integer id) {
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public HttpEntity<?> createUser(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteUser(@PathVariable("id") Integer id) {
       userService.delete(id);
       return ResponseEntity.ok().build();
    }

}
