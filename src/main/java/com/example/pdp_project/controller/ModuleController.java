package com.example.pdp_project.controller;

import com.example.pdp_project.dto.ModuleDTO;

import com.example.pdp_project.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/module")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;
    @GetMapping
    public HttpEntity<?> getModule() {
//        List<ModuleDTO> modules = moduleService.getAllModules();
        return ResponseEntity.ok(moduleService.getAllModules());
    }


    @GetMapping("/{id}")
    public HttpEntity<?> getModuleById(@PathVariable("id") Integer id) {
        ModuleDTO moduleById = moduleService.getModuleById(id);
        return ResponseEntity.ok(moduleById);
    }

    @PostMapping
    public HttpEntity<?> addModule(@RequestBody ModuleDTO module) {
        ModuleDTO module1 = moduleService.createModule(module);
        return ResponseEntity.status(HttpStatus.CREATED).body(module1);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteModuleById(@PathVariable("id") Integer id) {
        moduleService.getModuleById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/mudules/{id}")
    public HttpEntity<?> getMuduleById(@PathVariable("id") Integer id) {
        List<ModuleDTO> modulesByCourseId = moduleService.getModulesByCourseId(id);
        return ResponseEntity.ok(modulesByCourseId);
    }




}
