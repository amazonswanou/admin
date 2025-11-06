package com.example.demo.dao;

import com.example.demo.pojo.AttendanceManagement;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface AttendanceManagementDao {
    //查询
    @Select("select * from attendanceManagement")
    List<AttendanceManagement> getAttendanceManagementAull();

    //添加
    @Insert("INSERT INTO attendanceManagement (attendanceId,  date, name, className, course,attendanceLocation, courseTeacher,attendanceStatus) " +
            "VALUES (#{attendanceId},#{date}, #{name},#{className},#{course}, " +
            "#{attendanceLocation}, #{courseTeacher},#{attendanceStatus})")
    int InsertAttendanceManagement(AttendanceManagement attendanceManagement);

    @Update("UPDATE attendanceManagement SET date = #{date}, name = #{name}, className = #{className}, course = #{course},attendanceLocation = #{attendanceLocation}, courseTeacher = #{courseTeacher}, attendanceStatus = #{attendanceStatus} WHERE attendanceId = #{attendanceId}")
    int updateAttendanceManagementByDate(AttendanceManagement attendanceManagement);

    @Delete("DELETE FROM attendanceManagement WHERE attendanceId = #{attendanceId}")
    int deleteAttendanceManagementById(@Param("attendanceId") String attendanceId);

}
