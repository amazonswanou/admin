package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (AttendanceManagement)实体类
 *
 * @author makejava
 * @since 2024-11-03 13:37:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AttendanceManagement implements Serializable {


    private String attendanceId;

    private String date;

    private String name;

    private String className;

    private String course;

    private String attendanceLocation;
    private String courseTeacher;
    private String attendanceStatus;



}

