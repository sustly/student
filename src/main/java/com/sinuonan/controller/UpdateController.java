package com.sinuonan.controller;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
                         @ModelAttribute("id") String id,
                         Map<String, Object> map){
        StudentInfo info = new StudentInfo();
        info.setSchoolId(schoolId);
        info.setUuid(uuid);
        info.setGender(gender);
        info.setClassName(className);
        info.setName(name);
        info.setTeacherId(id);
        service.updateStudent(info);
        List<StudentInfo> list = service.findStudentByTeacherid(id);
        map.put("list",list);
        return "student_list";
    }

    @RequestMapping(value = "updateGo")
    public String updateGo(@RequestParam("uuid") String uuid, Map<String,Object> map){
        List<StudentInfo> students = service.findStudentByUuid(uuid);
        StudentInfo st = students.get(0);
        map.put("st",st);
        return "updateStudent";
    }
}
