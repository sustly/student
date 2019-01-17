package com.sinuonan.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sinuonan.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class DeleteController {
    @Resource(name = "StudentService")
    private StudentService service;

    @RequestMapping(value = "/deleteByName",method = RequestMethod.GET)
    public String deleteByName(@RequestParam("name") String name){
        service.deleteStudentByName(name);
        return "student_list";
    }
}
