package com.example.demo.service.impl;

import com.example.demo.dao.AdminlistDao;
import com.example.demo.pojo.Adminlist;
import com.example.demo.service.AdminlistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminlistServiceImpl implements AdminlistService {
    @Resource
    private AdminlistDao adminlistDao;

    @Override
    public List<Adminlist> getAdminlistaull() {
        return this.adminlistDao.getAdminlistaull();
    }

    @Override
    public Adminlist getAdminlistByUsername(String username) {
        return this.adminlistDao.getAdminlistByUsername(username);
    }

    @Override
    public Adminlist getAdminlistDl(String username, String password) {
        return this.adminlistDao.getAdminlistDl(username, password);
    }

    @Override
    public int updateAdminlist(String username, String password) {

        return this.adminlistDao.updateAdminlist(username, password);
    }
}
