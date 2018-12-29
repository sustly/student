package com.sinuonan.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import com.sinuonan.service.TeacherService;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginAction extends ActionSupport {
    private String id;
    private String password;


    @Resource(name = "teacherService")
    private TeacherService teacherService;
    @Resource(name = "StudentService")
    private StudentService studentService;

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String login(){
        return SUCCESS;
    }
    public String loginBy(){
        String t_password = teacherService.findPassowrdByid(id);
        if (password.equals(t_password)){
            List<StudentInfo> list = studentService.findStudentByTeacherid(id);
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("list",list);
            return SUCCESS;
        }else {
            this.addActionError("用户名或密码错误");
            return ERROR;
        }
    }
}
