package com.example.pdp_project.controller;

import com.example.pdp_project.dto.RolesDTO;
import com.example.pdp_project.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolesController {

    private final RolesService rolesService;

    @GetMapping
    public HttpEntity<?> getRoles() {

        List<RolesDTO> allRoles = rolesService.getAllRoles();
        return ResponseEntity.ok(allRoles);

    }

    @GetMapping("/{id}")
    public HttpEntity<?> getRole(@PathVariable("id") Integer id) {
        RolesDTO roleById = rolesService.getRoleById(id);
        return ResponseEntity.ok(roleById);
    }

    @PostMapping
    public HttpEntity<?> createRole(@RequestBody RolesDTO role) {
        RolesDTO role1 = rolesService.createRole(role);
        return ResponseEntity.ok(role1);
    }


    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteRole(@PathVariable("id") Integer id) {
        rolesService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

}
