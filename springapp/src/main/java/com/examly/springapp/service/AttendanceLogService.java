package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.AttendanceLog;
import com.examly.springapp.repository.AttendanceLogRepository;

@Service
public class AttendanceLogService {

    @Autowired
    private AttendanceLogRepository attendanceRepo;

    public AttendanceLog addAttendance(AttendanceLog log) {
        return attendanceRepo.save(log);
    }

    public AttendanceLog updateAttendance(Long id, AttendanceLog newLog) {
        Optional<AttendanceLog> existing = attendanceRepo.findById(id);

        if (existing.isPresent()) {
            AttendanceLog log = existing.get();
            log.setEmployeeCode(newLog.getEmployeeCode());
            log.setDate(newLog.getDate());
            log.setCheckInTime(newLog.getCheckInTime());
            log.setCheckOutTime(newLog.getCheckOutTime());
            return attendanceRepo.save(log);
        }
        return null;
    }

    public List<AttendanceLog> getAll() {
        return attendanceRepo.findAll();
    }
}
