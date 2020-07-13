package com.example.testlogin.mapper;

import com.example.testlogin.pojo.SysUser;
import org.apache.ibatis.annotations.Select;


public interface SysUserDao {
    @Select("SELECT * FROM sys_users WHERE username = #{username} AND password = #{password}")
    SysUser findUser(String username, String password);
}