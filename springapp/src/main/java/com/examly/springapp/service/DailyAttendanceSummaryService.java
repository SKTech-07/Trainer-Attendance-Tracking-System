package com.examly.springapp.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.DailyAttendanceSummary;
import com.examly.springapp.repository.DailyAttendanceSummaryRepository;

@Service
public class DailyAttendanceSummaryService {

    @Autowired
    private DailyAttendanceSummaryRepository repo;

    public Page<DailyAttendanceSummary> getByEmployeeId(
            Long empId, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        return repo.findByEmployeeId(empId, pageable);
    }

    public Page<DailyAttendanceSummary> getByEmployeeCodeAndDateRange(
            String code, LocalDate start, LocalDate end,
            int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        return repo.findByEmployeeCodeAndDateBetween(code, start, end, pageable);
    }

    public DailyAttendanceSummary add(DailyAttendanceSummary sum) {
        return repo.save(sum);
    }
}
