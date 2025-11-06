package com.example.demo.service.impl;

import com.example.demo.dao.GradeManagementDao;
import com.example.demo.dao.LeaveManagementDao;
import com.example.demo.pojo.GradeManagement;
import com.example.demo.pojo.LeaveManagement;
import com.example.demo.service.LeaveManaagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeaveManagementServiceImpl implements LeaveManaagementService {
    @Resource
    private LeaveManagementDao leaveManagementDao;

    @Override
    public List<LeaveManagement> getLeaveManagementAull() {
        return this.leaveManagementDao.getLeaveManagementAull();
    }

    @Override
    public int getLeaveManagementinsert(LeaveManagement leaveManagement) {
        this.leaveManagementDao.InsertLeaveManagement(leaveManagement);
        return 1;
    }

    @Override
    public int getLeaveManagementupdate(LeaveManagement leaveManagement) {
        return this.leaveManagementDao.updateLeaveManagementByDate(leaveManagement);
    }

    @Override
    public int deleteLeaveManagementById(String id) {
        return this.leaveManagementDao.deleteLeaveManagementById(id);
    }

}
