package com.sinuonan.controller;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import com.sinuonan.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
                        @RequestParam(value = "password") String password,HttpServletRequest request) {
        String t_password = teacherService.findPassowrdByid(id);
        if (password.equals(t_password)) {
            List<StudentInfo> list = studentService.findStudentByTeacherid(id);
            //teacher登陆成功后将id存入session中
            request.getSession().setAttribute("id", id);
            request.setAttribute("list", list);
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
