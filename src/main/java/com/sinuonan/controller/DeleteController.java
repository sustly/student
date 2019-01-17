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

@Controller
public class DeleteController {
    @Resource(name = "StudentService")
    private StudentService service;

    @RequestMapping(value = "/deleteByName",method = RequestMethod.GET)
    public String deleteByName(@RequestParam("name") String name, HttpServletRequest request){
        service.deleteStudentByName(name);

        String id = (String) request.getSession().getAttribute("id");
        List<StudentInfo> list = service.findStudentByTeacherid(id);
        request.setAttribute("list",list);
        return "student_list";
    }
}
