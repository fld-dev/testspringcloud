package com.example.testlogin.service;

import com.example.testlogin.pojo.SysUser;

public interface SysUserService {
    SysUser doLogin(String username, String password);
}
