package com.example.demo.controller;

import com.example.demo.pojo.AttendanceManagement;
import com.example.demo.service.AttendanceManagementService;
import com.example.demo.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendanceManagement")
public class AttendanceManagementController {

    @Autowired
    private AttendanceManagementService attendanceManagementService;

    // 查询
    @GetMapping("/select")
    public List<AttendanceManagement> getAttendanceManagementAull() {
        return attendanceManagementService.getAttendanceManagementAull();
    }
    //添加
    @PostMapping("/add")
    public ResponseEntity<String> addAttendance(@RequestBody AttendanceManagement attendanceManagement) {
            int result = attendanceManagementService.InsertAttendanceManagement(attendanceManagement);
        if (result == 1) {
            return ResponseEntity.ok("Attendance inserted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert attendance");
        }
    }


    //更新
    @PostMapping("/update")
    public ResponseEntity<?> updateAttendance(@RequestBody AttendanceManagement attendanceManagement) {
        try {
            int result = attendanceManagementService.UpdateAttendanceManagement(attendanceManagement);
            if (result > 0) {
                return ResponseEntity.ok("Attendance updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update attendance.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // 删除
    @DeleteMapping("/delete/{attendanceId}")
    public ResponseEntity<?> deleteAttendance(@PathVariable String attendanceId) {
        try {
            int result = attendanceManagementService.deleteAttendanceManagementById(attendanceId);
            if (result > 0) {
                return ResponseEntity.ok("Attendance deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete attendance.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

}
