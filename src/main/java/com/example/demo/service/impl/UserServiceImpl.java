package com.example.demo.service.impl;

import com.example.demo.pojo.Adminlist;
import com.example.demo.pojo.Studentlist;
import com.example.demo.pojo.Teacherlist;
import com.example.demo.service.AdminlistService;
import com.example.demo.service.StudentslistService;
import com.example.demo.service.TeacherService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AdminlistService adminlistService;

    @Autowired
    private StudentslistService studentslistService;

    @Autowired
    private TeacherService teacherService;

    @Override
    public boolean changePassword(String username, String newPassword) {
        logger.info("尝试修改密码，用户名: {}, 新密码: {}", username, newPassword);

        // 验证用户是否存在并更新密码
        Adminlist admin = adminlistService.getAdminlistByUsername(username);
        if (admin != null) {
            admin.setPassword(newPassword);
            adminlistService.updateAdminlist(admin.getUsername(), admin.getPassword());
            logger.info("管理员密码修改成功，用户名: {}", username);
            return true;
        }

        Studentlist student = studentslistService.getStudentByUsername(username);
        if (student != null) {
            student.setPassword(newPassword);
            studentslistService.updateStudent(student.getUsername(), student.getPassword());
            logger.info("学生密码修改成功，用户名: {}", username);
            return true;
        }

        Teacherlist teacher = teacherService.getTeacherByUsername(username);
        if (teacher != null) {
            teacher.setPassword(newPassword);
            teacherService.updateTeacher(teacher.getUsername(), teacher.getPassword());
            logger.info("教师密码修改成功，用户名: {}", username);
            return true;
        }

        logger.warn("用户不存在，用户名: {}", username);
        return false;
    }
}
