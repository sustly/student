package com.sinuonan.controller;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UpdateController{


    @Resource(name = "StudentService")
    private StudentService service;


    @RequestMapping(value = "update")
    public String update(@RequestParam("schoolId") Integer schoolId,
                         @RequestParam("name") String name,
                         @RequestParam("gender") String gender,
                         @RequestParam("className") String className,
                         @RequestParam("uuid") String uuid,
                         HttpServletRequest request){
        StudentInfo info = new StudentInfo();
        info.setSchoolId(schoolId);
        info.setUuid(uuid);
        info.setGender(gender);
        info.setClassName(className);
        info.setName(name);
        info.setTeacherId((String) request.getSession().getAttribute("id"));
        service.updateStudent(info);
        String id = (String) request.getSession().getAttribute("id");
        List<StudentInfo> list = service.findStudentByTeacherid(id);
        request.setAttribute("list",list);
        return "student_list";
    }

    @RequestMapping(value = "updateGo")
    public String updateGo(@RequestParam("uuid") String uuid,HttpServletRequest request){
        List<StudentInfo> students = service.findStudentByUuid(uuid);
        StudentInfo st = students.get(0);
        request.setAttribute("st",st);
        return "updateStudent";
    }
}
