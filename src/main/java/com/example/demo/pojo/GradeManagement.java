package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (GradeManagement)实体类
 *
 * @author makejava
 * @since 2024-11-03 13:37:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GradeManagement implements Serializable {
    private String gradeid;
    private String studentId;
    private String date;

    private String name;

    private String classname;

    private String course;

    private String attendanceLocation;

    private String courseteacher;

    private String grade;



}

