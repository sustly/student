package com.sinuonan.controller;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.bean.TeacherInfo;
import com.sinuonan.service.StudentService;
import com.sinuonan.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
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

    @ResponseBody
    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public Map<String, Object> checkUser(@RequestParam("username")String username){
        String passowrd = teacherService.findPassowrdByid(username);
        Map<String, Object> map = new HashMap<String, Object>();
        if (passowrd == null){
            map.put("isSuccess",false);
            map.put("Msg","用户名不正确！");
        }else {
            map.put("isSuccess",true);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/checkPassWord", method = RequestMethod.POST)
    public Map<String, Object> checkPassWord(@RequestBody TeacherInfo teacherInfo){
        String passowrd = teacherService.findPassowrdByid(teacherInfo.getId());
        Map<String, Object> map = new HashMap<String, Object>();
        if (!passowrd.equals(teacherInfo.getPassword())){
            map.put("isSuccess",false);
            map.put("Msg","密码不正确！");
        }else {
            map.put("isSuccess",true);
        }
        return map;
    }
}
