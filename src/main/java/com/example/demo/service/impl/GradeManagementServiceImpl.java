package com.example.demo.service.impl;

import com.example.demo.dao.GradeManagementDao;
import com.example.demo.pojo.GradeManagement;
import com.example.demo.service.GradeManagementSerice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class GradeManagementServiceImpl implements GradeManagementSerice {
    @Resource
    private GradeManagementDao gradeManagementDao;
    //查询
    @Override
    public List<GradeManagement> getGradeManagementAull() {
        return this.gradeManagementDao.getGradeManagementAull();
    }

    @Override
    public List<GradeManagement> getGradeManagementByStudentId(String studentId) {
        return this.gradeManagementDao.getGradeManagementByStudentId(studentId);
    }

    @Override
    public int getGradeManagementinsert(GradeManagement gradeManagement) {

        gradeManagementDao.InsertGradeManagement(gradeManagement);
        return 1;
    }

    @Override
    public int getGradeManagementupdate(GradeManagement gradeManagement) {
        return this.gradeManagementDao.updateGradeManagementByDate(gradeManagement);
    }

    @Override
    public int deleteGradeManagemenById(String gradeid) {
        return this.gradeManagementDao.deleteGradeManagementById(gradeid);
    }


}
