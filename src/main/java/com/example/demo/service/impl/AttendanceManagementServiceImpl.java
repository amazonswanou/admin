package com.example.demo.service.impl;

import com.example.demo.dao.AttendanceManagementDao;
import com.example.demo.pojo.AttendanceManagement;
import org.springframework.stereotype.Service;
import com.example.demo.service.AttendanceManagementService;
import javax.annotation.Resource;
import java.util.List;
@Service
public class AttendanceManagementServiceImpl implements AttendanceManagementService {
    @Resource
    private AttendanceManagementDao attendanceManagementDao;
    //查询
    @Override
    public List<AttendanceManagement> getAttendanceManagementAull() {
        return this.attendanceManagementDao.getAttendanceManagementAull();
    }

    @Override
    public int InsertAttendanceManagement(AttendanceManagement attendanceManagement) {

        attendanceManagementDao.InsertAttendanceManagement(attendanceManagement);
        return 1;
    }

    @Override
    public int UpdateAttendanceManagement(AttendanceManagement attendanceManagement) {
        return this.attendanceManagementDao.updateAttendanceManagementByDate(attendanceManagement);
    }

    @Override
    public int deleteAttendanceManagementById(String attendanceId) {
        return this.attendanceManagementDao.deleteAttendanceManagementById(attendanceId);
    }

}
