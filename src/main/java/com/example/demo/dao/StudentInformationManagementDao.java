package com.example.demo.dao;

import com.example.demo.pojo.StudentInformationManagement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentInformationManagementDao {
    //查询
    @Select("select * from studentinformationmanagement")
    List<StudentInformationManagement> getStudentInformationManagementAull();
    //根据id查询
    @Select("SELECT sim.* " +
            "FROM `555`.studentlist sl " +
            "JOIN `555`.studentinformationmanagement sim " +
            "ON sl.username COLLATE utf8mb4_unicode_ci = sim.studentId " +
            "WHERE sl.username COLLATE utf8mb4_unicode_ci = #{username}")
    StudentInformationManagement getStudentInfoByUserName(@Param("username") String username);

    //添加

    @Insert("INSERT INTO studentinformationmanagement (studentId, name, gender, birthDate, ethnicity, politicalStatus, enrollmentDate, expectedGraduationDate, hometown, idCardNumber, householdType, candidateType, admissionType, mobilePhone,email,qqAccount,wechatAccount) VALUES (#{studentId}, #{name}, #{gender}, #{birthDate}, #{ethnicity}, #{politicalStatus}, #{enrollmentDate}, #{expectedGraduationDate}, #{hometown}, #{idCardNumber}, #{householdType}, #{candidateType}, #{admissionType}, #{mobilePhone},#{email},#{qqAccount}, #{wechatAccount})")
    int Insertstudentinformationmanagement(StudentInformationManagement studentInformationManagement);


    @Update("UPDATE studentinformationmanagement SET name = #{name}, gender = #{gender}, birthDate = #{birthDate}, ethnicity = #{ethnicity}, politicalStatus = #{politicalStatus}, enrollmentDate = #{enrollmentDate}, expectedGraduationDate = #{expectedGraduationDate}, hometown = #{hometown}, idCardNumber = #{idCardNumber}, householdType = #{householdType}, candidateType = #{candidateType}, admissionType = #{admissionType}, mobilePhone = #{mobilePhone} WHERE studentId = #{studentId}")
    int updatestudentinformationmanagementByDate(StudentInformationManagement studentInformationManagement);


    @Delete("DELETE FROM studentinformationmanagement WHERE studentId = #{studentId}")
    int deletestudentinformationmanagementById(@Param("studentId") String studentId);

}
