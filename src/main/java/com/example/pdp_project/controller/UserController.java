package com.example.pdp_project.controller;

import com.example.pdp_project.dto.RegisterDTO;
import com.example.pdp_project.dto.UserDTO;
import com.example.pdp_project.dto.UserUpdateDTO;
import com.example.pdp_project.entity.User;
import com.example.pdp_project.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
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
    @PutMapping()
    public ResponseEntity<?> updateCourse(@RequestBody @Valid UserUpdateDTO user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    // Put mapping qoshish kerak

//    @PostMapping
//    public ResponseEntity<?> registerPage() {
//        return ResponseEntity.ok().body("");
//    }
//
//
//    @DeleteMapping("/{id}")
//    public HttpEntity<?> deleteUser(@PathVariable("id") Integer id) {
//       userService.delete(id);
//       return ResponseEntity.ok().build();
//    }

}
