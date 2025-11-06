package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Teacherlist)实体类
 *
 * @author makejava
 * @since 2024-11-03 13:37:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacherlist implements Serializable {

    private String teacherId;

    private String teacherName;

    private String teacherSex;

    private String teacherAge;

    private String role;

    private String username;

    private String password;




}

