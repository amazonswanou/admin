package com.example.demo.controller;

import com.example.demo.pojo.GradeManagement;
import com.example.demo.service.GradeManagementSerice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * GradeManagementController 是一个用于管理学生成绩的控制器类。
 * 该控制器提供了查询、添加、更新和删除成绩的功能。
 */
@RequestMapping("/GradeManagement")
@RestController
public class GradeManagementController {

    @Resource
    private GradeManagementSerice gradeManagementSerice;

    /**
     * 查询所有成绩信息。
     *
     * @return 成绩列表
     */
    @GetMapping("/select")
    public List<GradeManagement> getGradeManagementAull() {
        return gradeManagementSerice.getGradeManagementAull();
    }

    /**
     * 根据学生用户名查询该学生的成绩信息。
     *
     * @param username 学生用户名
     * @return 包含成绩列表的 ResponseEntity 对象
     */
    @GetMapping("/student/{username}")
    public ResponseEntity<List<GradeManagement>> getStudentGrades(@PathVariable String username) {
        List<GradeManagement> gradeManagement = gradeManagementSerice.getGradeManagementByStudentId(username);
        if (gradeManagement != null){
            return ResponseEntity.ok(gradeManagement);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /**
     * 添加新的成绩信息。
     *
     * @param gradeManagement 要添加的成绩对象
     * @return 包含操作结果的 ResponseEntity 对象
     */
    @PostMapping("/add")
    public ResponseEntity<String> addGradeManagement(@RequestBody GradeManagement gradeManagement) {
        int result = gradeManagementSerice.getGradeManagementinsert(gradeManagement);
        if (result == 1) {
            return ResponseEntity.ok("Attendance inserted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert attendance");
        }
    }

    /**
     * 更新已有的成绩信息。
     *
     * @param gradeManagement 要更新的成绩对象
     * @return 包含操作结果的 ResponseEntity 对象
     */
    @PostMapping("/update")
    public ResponseEntity<?> updateGradeManagement(@RequestBody GradeManagement gradeManagement) {
        try {
            int result = gradeManagementSerice.getGradeManagementupdate(gradeManagement);
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

    /**
     * 根据成绩 ID 删除成绩信息。
     *
     * @param gradeid 成绩 ID
     * @return 包含操作结果的 ResponseEntity 对象
     */
    @DeleteMapping("/delete/{gradeid}")
    public ResponseEntity<?> deleteGradeManagement(@PathVariable String gradeid) {
        try {
            int result = gradeManagementSerice.deleteGradeManagemenById(gradeid);
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
