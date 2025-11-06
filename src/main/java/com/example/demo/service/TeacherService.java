package com.example.demo.service;

import com.example.demo.pojo.Teacherlist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherService {
    Teacherlist getTeacherDl(String username, String password);

    // 更新教师信息
    int updateTeacher(String username, String password);
    Teacherlist getTeacherByUsername(String username);
}
