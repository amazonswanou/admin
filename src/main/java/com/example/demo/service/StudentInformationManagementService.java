package com.example.demo.service;

import com.example.demo.pojo.StudentInformationManagement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentInformationManagementService {
    //查询
    List<StudentInformationManagement> getStudentInformationManagementAull();
    //根据id查询
    StudentInformationManagement getStudentInfoByUserName(String username);

    //添加
    int getStudentInformationManagementinsert(StudentInformationManagement studentInformationManagement);
    //更新
    int getStudentInformationManagementupdate(StudentInformationManagement studentInformationManagement);
    //删除
    int deleteStudentInformationManagementById(String studentId);
}
