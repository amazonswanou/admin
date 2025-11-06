package com.example.demo.service;

import com.example.demo.pojo.Adminlist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminlistService {
    List<Adminlist> getAdminlistaull();

    Adminlist getAdminlistByUsername(String username);



    // 登录
    Adminlist getAdminlistDl(String username, String password);

    // 更新管理员信息
    int updateAdminlist(String username, String password);
}
