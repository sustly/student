package com.sinuonan.controller;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
                             HttpServletRequest request){
        StudentInfo info = new StudentInfo();
        info.setClassName(className);
        info.setGender(gender);
        info.setSchoolId(schoolId);
        info.setName(name);
        //从session中获得teacher的id
        String teacherId = (String) request.getSession().getAttribute("id");
        info.setTeacherId(teacherId);
        info.setUuid(UUID.randomUUID().toString());

        service.addStudent(info);

        String id = (String) request.getSession().getAttribute("id");
        List<StudentInfo> list = service.findStudentByTeacherid(id);
        request.setAttribute("list",list);

        return "student_list";
    }
    @RequestMapping(value = "/addStudentGo")
    public String addStudentGo(){
        return "addStudent";
    }
}
