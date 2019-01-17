package com.sinuonan.controller;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import com.sinuonan.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@SessionAttributes(value = "id")
@Controller
public class LoginController{

    @Resource(name = "teacherService")
    private TeacherService teacherService;
    @Resource(name = "StudentService")
    private StudentService studentService;

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/teacherLogin", method = RequestMethod.POST)
    public String teacherLogin(@RequestParam(value = "id") String id,
                               @RequestParam(value = "password") String password,
                               Map<String,Object> map) {
        String t_password = teacherService.findPassowrdByid(id);
        if (password.equals(t_password)) {
            List<StudentInfo> list = studentService.findStudentByTeacherid(id);
            //teacher登陆成功后将id存入session中
            map.put("id",id);
            map.put("list",list);
            return "student_list";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
}
