package com.example.demo.controller;

import com.example.demo.pojo.*;
import com.example.demo.pojo.request.ChangePasswordRequest;
import com.example.demo.pojo.request.LoginRequest;
import com.example.demo.service.AdminlistService;
import com.example.demo.service.StudentslistService;
import com.example.demo.service.TeacherService;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    // 日志记录器，用于记录日志信息
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    // 依赖注入的服务类
    @Autowired
    private AdminlistService adminlistService;

    @Autowired
    private StudentslistService studentslistService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    /**
     * 用户登录接口
     *
     * @param loginRequest 包含用户名、密码和角色的登录请求对象
     * @return 返回包含登录结果的 ResponseEntity
     */
    @PostMapping("/login")
    public ResponseEntity<ResultMap<?>> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        String role = loginRequest.getRole();

        // 记录登录尝试的日志信息
        logger.info("登录尝试，用户名: {}, 角色: {}", username, role);

        // 检查输入是否为空
        if (isNullOrEmpty(username) || isNullOrEmpty(password) || isNullOrEmpty(role)) {
            ResultMap<String> resultMap = new ResultMap<>();
            resultMap.setMessage("账号、密码或角色为空!");
            resultMap.setSuccess(false);
            return ResponseEntity.badRequest().body(resultMap);
        }

        // 根据角色类型进行不同的登录验证
        switch (role.toLowerCase()) {
            case "admin":
                Adminlist admin = adminlistService.getAdminlistDl(username, password);
                if (admin != null) {
                    ResultMap<Adminlist> resultMap = new ResultMap<>();
                    resultMap.setSuccess(true);
                    resultMap.setMessage("登录成功");
                    resultMap.setData(admin);
                    return ResponseEntity.ok(resultMap);
                }
                break;
            case "student":
                Studentlist student = studentslistService.getStudentDl(username, password);
                if (student != null) {
                    ResultMap<Studentlist> resultMap = new ResultMap<>();
                    resultMap.setSuccess(true);
                    resultMap.setMessage("登录成功");
                    resultMap.setData(student);
                    return ResponseEntity.ok(resultMap);
                }
                break;
            case "teacher":
                Teacherlist teacher = teacherService.getTeacherDl(username, password);
                if (teacher != null) {
                    ResultMap<Teacherlist> resultMap = new ResultMap<>();
                    resultMap.setSuccess(true);
                    resultMap.setMessage("登录成功");
                    resultMap.setData(teacher);
                    return ResponseEntity.ok(resultMap);
                }
                break;
            default:
                ResultMap<String> resultMap = new ResultMap<>();
                resultMap.setMessage("未知的角色类型");
                resultMap.setSuccess(false);
                return ResponseEntity.badRequest().body(resultMap);
        }

        // 如果登录失败，返回错误信息
        ResultMap<String> resultMap = new ResultMap<>();
        resultMap.setSuccess(false);
        resultMap.setMessage("登录失败，用户名或密码错误");
        return ResponseEntity.status(401).body(resultMap);
    }

    /**
     * 修改密码接口
     *
     * @param changePasswordRequest 包含用户名、新密码和角色的修改密码请求对象
     * @return 返回包含修改密码结果的 ResponseEntity
     */
    @PostMapping("/change-password")
    public ResponseEntity<ResultMap<?>> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        String username = changePasswordRequest.getUsername();
        String newPassword = changePasswordRequest.getNewPassword();
        String role = changePasswordRequest.getRole(); // 假设请求中包含角色信息
        // 记录修改密码尝试的日志信息
        logger.info("修改密码尝试，用户名: {}, 角色: {}, 新密码: {}", username, role, newPassword);
        // 检查输入是否为空
        if (isNullOrEmpty(username) || isNullOrEmpty(newPassword) || isNullOrEmpty(role)) {
            ResultMap<String> resultMap = new ResultMap<>();
            resultMap.setMessage("账号、新密码或角色为空!");
            resultMap.setSuccess(false);
            return ResponseEntity.badRequest().body(resultMap);
        }

        // 检查角色是否有权限修改密码
        if (!"teacher".equalsIgnoreCase(role) && !"admin".equalsIgnoreCase(role)) {
            ResultMap<String> resultMap = new ResultMap<>();
            resultMap.setMessage("无权限修改密码");
            resultMap.setSuccess(false);
            return ResponseEntity.status(403).body(resultMap);
        }

        // 调用服务层方法修改密码
        boolean success = userService.changePassword(username, newPassword); // 更新方法调用

        if (success) {
            ResultMap<String> resultMap = new ResultMap<>();
            resultMap.setMessage("密码修改成功");
            resultMap.setSuccess(true);
            return ResponseEntity.ok(resultMap);
        } else {
            ResultMap<String> resultMap = new ResultMap<>();
            resultMap.setMessage("密码修改失败");
            resultMap.setSuccess(false);
            return ResponseEntity.status(500).body(resultMap);
        }
    }

    /**
     * 检查字符串是否为空或仅包含空白字符
     *
     * @param str 需要检查的字符串
     * @return 如果字符串为空或仅包含空白字符，则返回 true；否则返回 false
     */
    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
