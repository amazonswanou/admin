package com.example.demo.service;

import com.example.demo.pojo.Studentlist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentslistService {
    Studentlist getStudentDl(String username, String password);

    // 更新学生信息
    int updateStudent(String username, String password);
    Studentlist getStudentByUsername(String username);
}
