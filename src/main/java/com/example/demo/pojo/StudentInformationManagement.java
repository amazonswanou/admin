package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (StudentInformationManagementDao)实体类
 *
 * @author makejava
 * @since 2024-11-03 13:37:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentInformationManagement implements Serializable {


    private String studentId;

    private String name;

    private String gender;

    private String birthDate;

    private String ethnicity;

    private String politicalStatus;

    private String enrollmentDate;

    private String expectedGraduationDate;

    private String hometown;

    private String idCardNumber;

    private String householdType;

    private String candidateType;

    private String admissionType;

    private String mobilePhone;
    private String email;
    private String qqAccount;
    private String wechatAccount;




}

