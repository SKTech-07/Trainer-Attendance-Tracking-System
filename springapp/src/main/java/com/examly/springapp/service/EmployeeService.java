package com.examly.springapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Employee;
import com.examly.springapp.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee save(Employee employee) {
        return repo.save(employee);
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }
}
