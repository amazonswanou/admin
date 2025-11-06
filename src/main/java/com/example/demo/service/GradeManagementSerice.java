package com.example.demo.service;

import com.example.demo.pojo.GradeManagement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface GradeManagementSerice {
    //查询
    List<GradeManagement> getGradeManagementAull();
    List<GradeManagement> getGradeManagementByStudentId(String studentId);
    //添加
    int getGradeManagementinsert(GradeManagement gradeManagement);
    //更新
    int getGradeManagementupdate(GradeManagement GradeManagement);
    //删除
    int deleteGradeManagemenById(String gradeid);
}
