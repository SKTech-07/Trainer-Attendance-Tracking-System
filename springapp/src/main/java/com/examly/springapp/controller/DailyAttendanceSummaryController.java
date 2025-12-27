package com.examly.springapp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.DailyAttendanceSummary;
import com.examly.springapp.service.DailyAttendanceSummaryService;


@RestController
@RequestMapping("/daily-summary")
public class DailyAttendanceSummaryController {

    @Autowired
    private DailyAttendanceSummaryService service;

    @GetMapping("/employee/{id}")
    public ResponseEntity<Page<DailyAttendanceSummary>> getByEmployeeId(
            @PathVariable Long id,
            @RequestParam int page,
            @RequestParam int size) {

        return ResponseEntity.ok(service.getByEmployeeId(id, page, size));
    }

    @GetMapping("/employee/code/{code}")
    public ResponseEntity<Page<DailyAttendanceSummary>> getByEmployeeCode(
            @PathVariable String code,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            @RequestParam int page,
            @RequestParam int size) {

        return ResponseEntity.ok(
                service.getByEmployeeCodeAndDateRange(
                        code, startDate, endDate, page, size));
    }

    @PostMapping("/create")
    public ResponseEntity<DailyAttendanceSummary> create(
            @RequestBody DailyAttendanceSummary sum) {

        return ResponseEntity.ok(service.add(sum));
    }

    
}

