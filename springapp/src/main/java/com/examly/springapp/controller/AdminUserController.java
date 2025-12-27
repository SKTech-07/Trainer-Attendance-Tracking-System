package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.AdminUser;
import com.examly.springapp.service.AdminUserService;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminUserService service;

    @PostMapping("/create")
    public ResponseEntity<AdminUser> addAdmin(@RequestBody AdminUser admin) {
        return ResponseEntity.ok(service.add(admin));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminUser> getAdminById(@PathVariable Long id) {
        return service.getById(id)
                .map(admin -> ResponseEntity.ok(admin))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminUser> updateAdmin(
            @PathVariable Long id,
            @RequestBody AdminUser admin) {

        return ResponseEntity.ok(service.update(id, admin));
    }

    @GetMapping
    public ResponseEntity<List<AdminUser>> getAllAdmins() {
        return ResponseEntity.ok(service.read());
    }
}
