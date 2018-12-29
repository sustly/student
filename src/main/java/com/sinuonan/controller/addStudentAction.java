package com.sinuonan.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.UUID;

@Controller
public class addStudentAction extends ActionSupport {
    private String name;
    private String gender;
    private String className;
    private Integer schoolId;

    @Resource(name = "StudentService")
    private StudentService service;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
    public String addStudent(){
        StudentInfo info = new StudentInfo();
        info.setClassName(className);
        info.setGender(gender);
        info.setSchoolId(schoolId);
        info.setName(name);
        String teacherId = (String) ServletActionContext.getRequest().getSession().getAttribute("id");
        info.setTeacherId(teacherId);
        info.setUuid(UUID.randomUUID().toString());

        service.addStudent(info);

        return SUCCESS;
    }
}
