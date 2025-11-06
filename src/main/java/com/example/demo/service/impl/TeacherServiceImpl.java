package com.example.demo.service.impl;

import com.example.demo.dao.TeacherlistDao;
import com.example.demo.pojo.Teacherlist;
import com.example.demo.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherlistDao teacherlistDao;

    @Override
    public Teacherlist getTeacherDl(String username, String password) {
        return this.teacherlistDao.getTeacherDl(username, password);
    }

    @Override
    public int updateTeacher(String username, String password) {
        return this.teacherlistDao.updateTeacher(username, password);
    }

    @Override
    public Teacherlist getTeacherByUsername(String username) {
        return this.teacherlistDao.getTeacherByUsername(username);
    }
}
