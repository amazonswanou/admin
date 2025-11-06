package com.example.demo.service.impl;

import com.example.demo.dao.StudentInformationManagementDao;
import com.example.demo.pojo.StudentInformationManagement;
import com.example.demo.service.StudentInformationManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service

public class StudentInformationManagementServiceImpl implements StudentInformationManagementService {
    @Resource
    private StudentInformationManagementDao studentInformationManagementDao;
    @Override
    public List<StudentInformationManagement> getStudentInformationManagementAull() {
        return this.studentInformationManagementDao.getStudentInformationManagementAull();
    }
    //根据id查询

    @Override
    public StudentInformationManagement getStudentInfoByUserName(String username) {
        return this.studentInformationManagementDao.getStudentInfoByUserName(username);
    }

    @Override
    public int getStudentInformationManagementinsert(StudentInformationManagement studentInformationManagement) {
        studentInformationManagementDao.Insertstudentinformationmanagement(studentInformationManagement);
        return 1;
    }

    @Override
    public int getStudentInformationManagementupdate(StudentInformationManagement studentInformationManagement) {
        return this.studentInformationManagementDao.updatestudentinformationmanagementByDate(studentInformationManagement);
    }

    @Override
    public int deleteStudentInformationManagementById(String studentId) {
        return this.studentInformationManagementDao.deletestudentinformationmanagementById(studentId);
    }
}
