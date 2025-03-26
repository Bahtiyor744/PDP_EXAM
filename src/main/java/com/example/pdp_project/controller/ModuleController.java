package com.example.pdp_project.controller;

import com.example.pdp_project.dto.ModuleDTO;
import com.example.pdp_project.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/module")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping
    public HttpEntity<List<ModuleDTO>> getModule() {
        return ResponseEntity.ok(moduleService.getAllModules());
    }

    @GetMapping("/byCourseId/{courseId}")
    public HttpEntity<?> getModuleByCourseId(@PathVariable("courseId") Integer courseId) {
        return ResponseEntity.ok(moduleService.getModulesByCourseId(courseId));
    }

//    @GetMapping("/{id}")
//    public HttpEntity<ModuleDTO> getModuleById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(moduleService.getModuleById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<?> addModule(@RequestBody @Valid ModulePostDTO module) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(moduleService.createModule(module));
//    }
//
//    @PutMapping
//    public ResponseEntity<ModuleDTO> updateModule(ModuleDTO moduleDTO) {
//        return ResponseEntity.ok(moduleService.updateModule(moduleDTO));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteModuleById(@PathVariable("id") Integer id) {
//        moduleService.deleteModule(id);
//        return ResponseEntity.noContent().build();
//    }
}
