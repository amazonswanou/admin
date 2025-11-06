package com.example.demo.controller;

import com.example.demo.pojo.GradeManagement;
import com.example.demo.pojo.LeaveManagement;
import com.example.demo.service.LeaveManaagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/LeaveManagement")
@RestController
public class LeaveManagementController {
    @Resource
    private LeaveManaagementService leaveManaagementService;
    //查询
    @GetMapping("/select")
    public List<LeaveManagement> getLeaveManagementAull() {
        return leaveManaagementService.getLeaveManagementAull();
    }
    //添加
    @PostMapping("/add")
    public ResponseEntity<String> addLeaveManagement(@RequestBody LeaveManagement leaveManagement) {
        int result = leaveManaagementService.getLeaveManagementinsert(leaveManagement);
        if (result == 1) {
            return ResponseEntity.ok("Attendance inserted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert attendance");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateLeaveManagement(@RequestBody LeaveManagement leaveManagement) {
        try {
            int result = leaveManaagementService.getLeaveManagementupdate(leaveManagement);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLeaveManagement(@PathVariable String id) {
        try {
            int result = leaveManaagementService.deleteLeaveManagementById(id);
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
