package com.example.demo.dao;

import com.example.demo.pojo.Studentlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentslistDao {
    @Select("SELECT * FROM Studentlist WHERE username = #{username} AND password = #{password} LIMIT 1")
    Studentlist getStudentDl(@Param("username") String username, @Param("password") String password);

    @Update("UPDATE Studentlist SET password = #{password} WHERE username = #{username}")
    int updateStudent(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM Studentlist WHERE username = #{username}")
    Studentlist getStudentByUsername(@Param("username") String username);
}
