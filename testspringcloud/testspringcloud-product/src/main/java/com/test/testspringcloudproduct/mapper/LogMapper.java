package com.test.testspringcloudproduct.mapper;

import com.test.testspringcloudproduct.po.SysLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogMapper {
    /**
     * 保存日志信息到数据库
     * @param entity
     * @return
     */
    @Insert("insert into sys_logs(username,operation,method,params,time,ip,createdTime) values(#{username},#{operation},#{method},#{params},#{time},#{ip},#{createdTime})")
    int insertObject(SysLog entity);

    /**
     * 基于日志id执行删除操作
     * @param ids
     * @return
     */
    @Delete({"<script> delete from sys_logs where id in <foreach collection='ids' items='items' index='index' separator=',' open='(' close=')' >#{items} </foreach> </script>"})
    int deleteObjects(@Param("ids")Integer... ids);//JDK1.5

    /**
     * 基于条件分页查询日志信息
     * @param username  查询条件(例如查询哪个用户的日志信息)
     * @param startIndex 当前页的起始位置
     * @param pageSize 当前页的页面大小
     * @return 当前页的日志记录信息
     * 数据库中每条日志信息封装到一个SysLog对象中
     */
    @Select("select * from sys_logs where username like concat('%',#{username},'%') order by createdTime desc limit #{startIndex},#{pageSize}")
    List<SysLog> findPageObjects(@Param("username")String  username, @Param("startIndex")Integer startIndex, @Param("pageSize")Integer pageSize);

    /**
     * 基于条件查询总记录数
     * @param username 查询条件(例如查询哪个用户的日志信息)
     * @return 总记录数(基于这个结果可以计算总页数)
     * 说明：假如如下方法没有使用注解修饰，在基于名字进行查询
     * 时候会出现There is no getter for property named
     * 'username' in 'class java.lang.String'
     */
    @Select("select count(*) from sys_logs where username like concat('%',#{username},'%')")
    int getRowCount(@Param("username") String username);
}
