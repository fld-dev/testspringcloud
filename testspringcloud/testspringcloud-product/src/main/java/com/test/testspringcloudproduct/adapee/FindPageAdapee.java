package com.test.testspringcloudproduct.adapee;

import com.test.testspringcloudproduct.mapper.LogMapper;
import com.test.testspringcloudproduct.po.SysLog;
import com.test.testspringcloudproduct.vo.PageObject;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindPageAdapee {

    @Autowired
    LogMapper logMapper;

    public PageObject<SysLog> invoke(String username, Integer pageCurrent) {
        //1.参数有效性验证(只验证pageCurrent)
        if(pageCurrent==null||pageCurrent<1)
            throw new IllegalArgumentException("页码值不正确");
        //2.查询总记录数并进行验证
        int rowCount=logMapper.getRowCount(username);
        if(rowCount==0)
            throw new ServiceException("没有对应记录");
        //3.查询当前页日志数据
        int pageSize=2;
        int startIndex=(pageCurrent-1)*pageSize;
        List<SysLog> records=
                logMapper.findPageObjects(username,
                        startIndex, pageSize);
        //4.对查询结果进行封装
        PageObject<SysLog> po=new PageObject<>();
        po.setRecords(records);
        po.setRowCount(rowCount);
        po.setPageSize(pageSize);
        po.setPageCurrent(pageCurrent);
	  /*int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}*/
        //po.setPageCount((rowCount-1)/pageSize+1);
        //5.返回结果
        return po;
    }
}
