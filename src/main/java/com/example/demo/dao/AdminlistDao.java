package com.example.demo.dao;

import com.example.demo.pojo.Adminlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminlistDao {
    @Select("select * from Adminlist")
    List<Adminlist> getAdminlistaull();

    @Select("SELECT * FROM Adminlist WHERE username = #{username} AND password = #{password} LIMIT 1")
    Adminlist getAdminlistDl(@Param("username") String username, @Param("password") String password);

    @Update("UPDATE Adminlist SET password = #{password} WHERE username = #{username}")
    int updateAdminlist(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM Adminlist WHERE username = #{username}")
    Adminlist getAdminlistByUsername(@Param("username") String username);
}
