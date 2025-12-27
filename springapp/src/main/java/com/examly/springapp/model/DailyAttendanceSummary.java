package com.examly.springapp.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class DailyAttendanceSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int summaryId;

    private Long employeeId;
    private String employeeCode;

    private LocalDate date;

    public DailyAttendanceSummary() {}

    public int getSummaryId() {
        return summaryId;
    }

    public void setSummaryId(int summaryId) {
        this.summaryId = summaryId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
