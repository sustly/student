package com.sinuonan.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sinuonan.service.StudentService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class updateAction extends ActionSupport {
    private Integer schoolId;
    private String name;

    @Resource(name = "StudentService")
    private StudentService service;

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String updateByname(){
        service.updateStudentByname(name, schoolId);
        return SUCCESS;
    }
}
