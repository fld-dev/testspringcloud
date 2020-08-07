package com.test.testspringcloudproduct.service;

import com.test.testspringcloudproduct.po.SysLog;
import com.test.testspringcloudproduct.vo.PageObject;

public interface LogService {

    int deleteObjects(Integer...ids);

    /**
     * 依据条件分页查询日志信息
     * @param username 用户名
     * @param pageCurrent 当前页码
     * @return 对查询结果的封装
     */
    PageObject<SysLog> findPageObjects(String username, Integer pageCurrent);
}
