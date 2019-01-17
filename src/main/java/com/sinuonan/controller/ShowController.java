package com.sinuonan.controller;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShowController{
    @Resource(name = "StudentService")
    private StudentService studentService;

    @RequestMapping(value = "showView")
    public String showView(HttpServletRequest request){
        //从session中获得id，用于查询
        String name = (String) request.getSession().getAttribute("id");
        List<StudentInfo> list = studentService.findStudentByTeacherid(name);
        request.setAttribute("list",list);
        return "student_list";
    }
}
