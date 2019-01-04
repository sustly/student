package com.sinuonan.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class updateAction extends ActionSupport {
    private String uuid;
    private String name;
    private String gender;
    private String className;
    private Integer schoolId;

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
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Resource(name = "StudentService")
    private StudentService service;



    public String update(){
        StudentInfo info = new StudentInfo();
        info.setSchoolId(schoolId);
        info.setUuid(uuid);
        info.setGender(gender);
        info.setClassName(className);
        info.setName(name);
        info.setTeacherId((String) ServletActionContext.getRequest().getSession().getAttribute("id"));
        service.updateStudent(info);
        return SUCCESS;
    }

    public String updateGo(){
        List<StudentInfo> students = service.findStudentByUuid(uuid);
        StudentInfo st = students.get(0);
        ServletActionContext.getRequest().setAttribute("st",st);
        return SUCCESS;
    }
}
