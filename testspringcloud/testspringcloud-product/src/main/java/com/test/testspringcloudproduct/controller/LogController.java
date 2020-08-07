package com.test.testspringcloudproduct.controller;

import com.test.testspringcloudproduct.po.SysLog;
import com.test.testspringcloudproduct.service.LogService;
import com.test.testspringcloudproduct.vo.JsonResult;
import com.test.testspringcloudproduct.vo.PageObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/log/")
public class LogController {

    @Autowired
    LogService logService;



    @RequestMapping("doLogListUI")
    public String doLogListUI(){
        //return "jsp/SysLog-AJAX";
        //return "jsp/SysLog-Jquery-AJAX";
        return "sys/log_list";
    }

    @RequestMapping("doFindPageSysLogs")
    public ModelAndView doFindPageSysLogs(
            String username,
            Integer pageCurrent){
        //模拟耗时操作
        try{Thread.sleep(5000);}catch(Exception e){}
        PageObject<SysLog> pageObject=
                logService.findPageObjects(
                        username,
                        pageCurrent);
        ModelAndView mv =new ModelAndView();
        mv.addObject("pageObject", pageObject);
        mv.setViewName("jsp/SysLog");
        return mv;
    }

    @RequestMapping("doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(
            Integer... ids){
        logService.deleteObjects(ids);
        return new JsonResult("删除成功");
    }

    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(
            String username,
            Integer pageCurrent){
        //模拟耗时操作
        //try{Thread.sleep(5000);}catch(Exception e){}
        PageObject<SysLog> pageObject=
                logService.findPageObjects(
                        username,
                        pageCurrent);
        return  new JsonResult(pageObject);
    }
}
