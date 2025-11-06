package com.example.demo.service;

import com.example.demo.pojo.Adminlist;
import com.example.demo.pojo.AttendanceManagement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AttendanceManagementService {
    //查询
    List<AttendanceManagement> getAttendanceManagementAull();
    //添加
    int InsertAttendanceManagement(AttendanceManagement attendanceManagement);

    //更新
    int UpdateAttendanceManagement(AttendanceManagement attendanceManagement);
    //删除
    int deleteAttendanceManagementById(String attendanceId);

}
