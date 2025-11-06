package com.example.demo.dao;

import com.example.demo.pojo.AttendanceManagement;
import com.example.demo.pojo.GradeManagement;
import com.example.demo.pojo.LeaveManagement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LeaveManagementDao {
    //查
    @Select("select * from leavemanagement")
    List<LeaveManagement> getLeaveManagementAull();

    @Insert("INSERT INTO leavemanagement (username,  studentId, leaveTime, reasonType, location, status,leaveStatus) " +
            "VALUES (#{username},#{studentId}, #{leaveTime},#{reasonType},#{location}, " +
            "#{status},#{leaveStatus})")
    int InsertLeaveManagement(LeaveManagement leaveManagement);

    @Update("UPDATE leavemanagement SET studentId = #{studentId} ,leaveTime = #{leaveTime}, reasonType = #{reasonType}, location = #{location}, status = #{status} WHERE id=#{id}")
    int updateLeaveManagementByDate(LeaveManagement leaveManagement);

    @Delete("DELETE FROM leavemanagement WHERE id = #{id}")
    int deleteLeaveManagementById(@Param("id") String id);
}
