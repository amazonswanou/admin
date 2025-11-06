package com.example.demo.dao;

import com.example.demo.pojo.Teacherlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TeacherlistDao {
    @Select("SELECT * FROM teacherlist WHERE username = #{username} AND password = #{password} LIMIT 1")
    Teacherlist getTeacherDl(@Param("username") String username, @Param("password") String password);

    @Update("UPDATE teacherlist SET password = #{password} WHERE username = #{username}")
    int updateTeacher(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM teacherlist WHERE username = #{username}")
    Teacherlist getTeacherByUsername(@Param("username") String username);
}
