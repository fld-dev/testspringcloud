package com.test.testspringcloudproduct.adapee;

import com.test.testspringcloudproduct.mapper.LogMapper;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteLogAdapee {

    @Autowired
    LogMapper logMapper;
    public int invoke(Integer... ids){
        if(ids==null||ids.length==0)
            throw new IllegalArgumentException("请先选中记录");
        int rows=0;
        try{
            rows=logMapper.deleteObjects(ids);
        }catch(Throwable e){
            e.printStackTrace();
            throw new ServiceException("系统维护中,稍等片刻");
        }
        if(rows==0)
            throw new ServiceException("记录可能已经不存在");
        return rows;
    }
}
