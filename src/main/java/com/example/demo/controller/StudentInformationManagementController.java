package com.example.demo.controller;

import com.example.demo.pojo.GradeManagement;
import com.example.demo.pojo.StudentInformationManagement;
import com.example.demo.service.GradeManagementSerice;
import com.example.demo.service.StudentInformationManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/StudentInformationManagement")
@RestController
public class StudentInformationManagementController {
    @Resource
    private StudentInformationManagementService studentInformationManagementService;
    //查询
    @GetMapping("/select")
    public List<StudentInformationManagement> getStudentInformationManagementAull() {
        return studentInformationManagementService.getStudentInformationManagementAull();
    }
    //根据登录的用户名查询该用户的信息
    @GetMapping("/select/{username}")
    public ResponseEntity<StudentInformationManagement> getStudentInformationManagementById(@PathVariable String username) {
        StudentInformationManagement studentInformationManagement = studentInformationManagementService.getStudentInfoByUserName(username);
        if (studentInformationManagement != null) {
            return ResponseEntity.ok(studentInformationManagement);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    //添加
    @PostMapping("/add")
    public ResponseEntity<String> addStudentInformationManagement(@RequestBody StudentInformationManagement studentInformationManagement) {
        int result = studentInformationManagementService.getStudentInformationManagementinsert(studentInformationManagement);
        if (result == 1) {
            return ResponseEntity.ok("Attendance inserted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert attendance");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateStudentInformationManagement(@RequestBody StudentInformationManagement studentInformationManagement) {
        try {
            int result = studentInformationManagementService.getStudentInformationManagementupdate(studentInformationManagement);
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

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity<?> deleteStudentInformationManagement(@PathVariable String studentId) {
        try {
            int result = studentInformationManagementService.deleteStudentInformationManagementById(studentId);
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
