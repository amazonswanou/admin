package com.example.demo.service;

import com.example.demo.pojo.GradeManagement;
import com.example.demo.pojo.LeaveManagement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeaveManaagementService {
    //查询
    List<LeaveManagement> getLeaveManagementAull();

    //添加
    int getLeaveManagementinsert(LeaveManagement leaveManagement);
    //更新
    int getLeaveManagementupdate(LeaveManagement leaveManagement);
    //删除
    int deleteLeaveManagementById(String id);
}
