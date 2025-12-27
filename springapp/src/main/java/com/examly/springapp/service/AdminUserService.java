package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.AdminUser;
import com.examly.springapp.repository.AdminUserRepository;

@Service
public class AdminUserService {

    @Autowired
    private AdminUserRepository repo;

    public AdminUser add(AdminUser admin) {
        return repo.save(admin);
    }

    public List<AdminUser> read() {
        return repo.findAll();
    }

    public java.util.Optional<AdminUser> getById(Long id) {
        return repo.findById(id);
    }

    public AdminUser update(Long id, AdminUser admin) {
        AdminUser existing = repo.findById(id).orElseThrow();
        existing.setUsername(admin.getUsername());
        existing.setPassword(admin.getPassword());
        return repo.save(existing);
    }
}
