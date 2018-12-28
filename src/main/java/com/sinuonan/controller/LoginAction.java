package com.sinuonan.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sinuonan.bean.TeacherInfo;
import com.sinuonan.service.TeacherService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author liyue
 * @date 2018/12/28 13:32
 */
@Controller
public class LoginAction extends ActionSupport {
    private String id;
    private String password;

    @Resource(name = "teacherService")
    private TeacherService service;

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
        String t_password = service.findPassowrdByid(id);
        if (password.equals(t_password)){
            return SUCCESS;
        }else {
            this.addActionError("用户名或密码错误");
            return ERROR;
        }
    }
}
