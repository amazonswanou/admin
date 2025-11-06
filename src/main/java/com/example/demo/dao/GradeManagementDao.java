package com.example.demo.dao;

import com.example.demo.pojo.GradeManagement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GradeManagementDao {
    //查询
    @Select("select * from grademanagement")
    List<GradeManagement> getGradeManagementAull();
    // 根据学生ID查询成绩（学生使用）
//    @Select("SELECT * FROM grademanagement WHERE studentId = #{studentId}")
//    GradeManagement getGradeManagementByStudentId(@Param("studentId") String studentId);
    @Select("SELECT sim.* " +
            "FROM `555`.studentlist sl " +
            "JOIN `555`.grademanagement sim " +
            "ON sl.username COLLATE utf8mb4_unicode_ci = sim.studentId " +
            "WHERE sl.username COLLATE utf8mb4_unicode_ci = #{username}")
    List<GradeManagement> getGradeManagementByStudentId(@Param("username") String username);
    //添加

    @Insert("INSERT INTO grademanagement ( studentId,date, name, classname, course, attendanceLocation, courseteacher, grade) " +
            "VALUES ( #{studentId}, #{date}, #{name}, #{classname}, #{course}, #{attendanceLocation}, " +
            "#{courseteacher}, #{grade})")
    int InsertGradeManagement(GradeManagement gradeManagement);

    @Update("UPDATE grademanagement SET studentId=#{studentId}, date = #{date}, name = #{name}, classname = #{classname}, course = #{course},attendanceLocation=#{attendanceLocation} ,courseteacher = #{courseteacher}, grade = #{grade} WHERE gradeid=#{gradeid}")
    int updateGradeManagementByDate(GradeManagement gradeManagement);

    @Delete("DELETE FROM grademanagement WHERE gradeid = #{gradeid}")
    int deleteGradeManagementById(@Param("gradeid") String gradeid);

}
