package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.AttendanceRecord;
import com.examly.springapp.repository.AttendanceRecordRepository;

@Service
public class AttendanceRecordService {

    @Autowired
    private AttendanceRecordRepository attendanceRecordRepository;

    public AttendanceRecord createAttendanceRecord(AttendanceRecord attendanceRecord) {
        return attendanceRecordRepository.save(attendanceRecord);
    }

    public List<AttendanceRecord> getAllAttendanceRecords() {
        return attendanceRecordRepository.findAll();
    }
}
