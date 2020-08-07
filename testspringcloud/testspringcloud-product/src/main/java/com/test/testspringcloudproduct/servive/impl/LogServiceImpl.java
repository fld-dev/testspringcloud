package com.test.testspringcloudproduct.servive.impl;

import com.test.testspringcloudproduct.adapee.DeleteLogAdapee;
import com.test.testspringcloudproduct.adapee.FindPageAdapee;
import com.test.testspringcloudproduct.po.SysLog;
import com.test.testspringcloudproduct.service.LogService;
import com.test.testspringcloudproduct.vo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    DeleteLogAdapee deleteLogAdapee;

    @Autowired
    FindPageAdapee findPageAdapee;

    @Override
    public int deleteObjects(Integer... ids) {
        return deleteLogAdapee.invoke(ids);
    }

    @Override
    public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
        return findPageAdapee.invoke(username, pageCurrent);
    }
}
