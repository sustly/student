package com.sinuonan.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sinuonan.service.StudentService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class deleteAction extends ActionSupport {
    private String name;
    @Resource(name = "StudentService")
    private StudentService service;

    public void setName(String name) {
        this.name = name;
    }
    public String deleteByName(){
        service.deleteStudentByName(name);
        return SUCCESS;
    }
}
