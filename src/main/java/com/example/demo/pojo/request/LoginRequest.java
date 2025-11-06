package com.example.demo.pojo.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
    private String role; // 用户类型，例如 "admin", "student", "teacher"
}
