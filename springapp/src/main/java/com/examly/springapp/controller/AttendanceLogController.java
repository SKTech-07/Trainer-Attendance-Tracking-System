package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.AttendanceLog;
import com.examly.springapp.service.AttendanceLogService;

@RestController
@RequestMapping("/attendancelogs")
public class AttendanceLogController {

    @Autowired
    private AttendanceLogService attendanceService;

    @PostMapping
    public ResponseEntity<AttendanceLog> addAttendance(@RequestBody AttendanceLog log) {
        return new ResponseEntity<>(attendanceService.addAttendance(log), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendanceLog> updateAttendance(
            @PathVariable Long id,
            @RequestBody AttendanceLog log) {

        AttendanceLog updated = attendanceService.updateAttendance(id, log);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AttendanceLog>> getAllAttendance() {
        return ResponseEntity.ok(attendanceService.getAll());
    }
}
