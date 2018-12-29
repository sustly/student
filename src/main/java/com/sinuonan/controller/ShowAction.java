package com.sinuonan.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ShowAction extends ActionSupport {
    @Resource(name = "StudentService")
    private StudentService studentService;
    public String showView(){
        String name = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
        List<StudentInfo> list = studentService.findStudentByTeacherid(name);
        ServletActionContext.getRequest().setAttribute("list",list);
        return SUCCESS;
    }
}
