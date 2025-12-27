package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.AttendanceRecord;
import com.examly.springapp.service.AttendanceRecordService;

@RestController
@RequestMapping("/attendance-records")
public class AttendanceRecordController {
    @Autowired
    private AttendanceRecordService attendanceRecordService;
    
    @GetMapping
    public ResponseEntity<List<AttendanceRecord>> getAllAttendanceRecords() {
        List<AttendanceRecord> records = attendanceRecordService.getAllAttendanceRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AttendanceRecord> createAttendanceRecord(
            @RequestBody AttendanceRecord attendanceRecord) {

        AttendanceRecord saved = attendanceRecordService.createAttendanceRecord(attendanceRecord);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
