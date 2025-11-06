package com.example.demo.service.impl;

import com.example.demo.dao.StudentslistDao;
import com.example.demo.pojo.Studentlist;
import com.example.demo.service.StudentslistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentslistServiceImpl implements StudentslistService {
    @Resource
    private StudentslistDao studentslistDao;

    @Override
    public Studentlist getStudentDl(String username, String password) {
        return this.studentslistDao.getStudentDl(username, password);
    }

    @Override
    public int updateStudent(String username, String password) {
        return this.studentslistDao.updateStudent(username, password);
    }

    @Override
    public Studentlist getStudentByUsername(String username) {
        return this.studentslistDao.getStudentByUsername(username);
    }
}
