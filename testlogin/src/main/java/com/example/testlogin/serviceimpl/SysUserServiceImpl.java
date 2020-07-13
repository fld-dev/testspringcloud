package com.example.testlogin.serviceimpl;

import com.example.testlogin.mapper.SysUserDao;
import com.example.testlogin.pojo.SysUser;
import com.example.testlogin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser doLogin(String username, String password) {
        return sysUserDao.findUser(username, password);
    }
}
