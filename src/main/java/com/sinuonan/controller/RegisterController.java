package com.sinuonan.controller;

import com.sinuonan.bean.TeacherInfo;
import com.sinuonan.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class RegisterController {

    @Resource(name = "teacherService")
    private TeacherService service;
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public String register(@RequestParam("id") String id,
                           @RequestParam("password") String password,
                           @RequestParam("rpassword") String rpassword){
        if (password.equals(rpassword)){
            TeacherInfo info = new TeacherInfo();
            info.setId(id);
            info.setPassword(password);
            service.save(info);
            return "login";
        }else {
            return "register";
        }
    }
}
