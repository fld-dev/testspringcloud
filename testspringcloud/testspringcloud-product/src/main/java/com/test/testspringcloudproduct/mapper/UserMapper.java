package com.test.testspringcloudproduct.mapper;

import com.test.testspringcloudproduct.po.SysUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM sys_users WHERE username=#{username}")
    SysUser findUserByUsername(@Param("username") String username);
}
