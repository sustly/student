package com.sinuonan.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sinuonan.bean.TeacherInfo;
import com.sinuonan.service.TeacherService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class RegisterAction extends ActionSupport {
    private String id;
    private String password;
    private String rpassword;
    @Resource(name = "teacherService")
    private TeacherService service;

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    public String register(){
        if (password.equals(rpassword)){
            TeacherInfo info = new TeacherInfo();
            info.setId(id);
            info.setPassword(password);
            service.save(info);
            return SUCCESS;
        }else {
            this.addActionError("两次密码不一致!");
            return ERROR;
        }
    }
}
