package com.sinuonan.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ShowController{
    @Resource(name = "StudentService")
    private StudentService studentService;

    @RequestMapping(value = "showView")
    public String showView(){
        //从session中获得id，用于查询
        String name = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
        List<StudentInfo> list = studentService.findStudentByTeacherid(name);
        ServletActionContext.getRequest().setAttribute("list",list);
        return "student_list";
    }
}
