package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Select("select id,username,password from user where username=#{username}")
    public User login(String username);
}
