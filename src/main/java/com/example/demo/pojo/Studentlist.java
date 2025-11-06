package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Studentlist)实体类
 *
 * @author makejava
 * @since 2024-11-03 13:37:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Studentlist implements Serializable {


    private String stuId;

    private String stuName;

    private String stuGrade;

    private String stuAge;

    private String stuSex;

    private String username;

    private String password;
    private String role;




}

