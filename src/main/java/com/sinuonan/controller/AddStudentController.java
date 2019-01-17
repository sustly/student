package com.sinuonan.controller;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 添加学生信息
 * 该类中的字段与jsp页面一一对应，可接收jsp请求的参数
 */
@Controller
public class AddStudentController {

    @Resource(name = "StudentService")
    private StudentService service;

    /**
     * 添加学生
     * @return
     */
    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public String addStudent(@RequestParam("name") String name,
                             @RequestParam("gender") String gender,
                             @RequestParam("className") String className,
                             @RequestParam("schoolId") Integer schoolId,
                             Map<String,Object> map,
                             @ModelAttribute(value = "id") String id){
        StudentInfo info = new StudentInfo();
        info.setClassName(className);
        info.setGender(gender);
        info.setSchoolId(schoolId);
        info.setName(name);
        info.setTeacherId(id);
        info.setUuid(UUID.randomUUID().toString());

        service.addStudent(info);

        List<StudentInfo> list = service.findStudentByTeacherid(id);
        map.put("list",list);

        return "student_list";
    }
    @RequestMapping(value = "/addStudentGo")
    public String addStudentGo(){
        return "addStudent";
    }
}
