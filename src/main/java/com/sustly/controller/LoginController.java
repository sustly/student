package com.sustly.controller;

import com.sustly.bean.StudentInfo;
import com.sustly.bean.TeacherInfo;
import com.sustly.service.StudentService;
import com.sustly.service.TeacherService;
import com.sustly.utils.md5.md5util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionAttributes(value = "id")
@Controller
@RequestMapping(value = "home")
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
        String md5Password = md5util.MD5Encode(password);
        String t_password = teacherService.findPassowrdByid(id);
        if (md5Password.equals(t_password)) {
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
        String md5Password = md5util.MD5Encode(teacherInfo.getPassword());
        Map<String, Object> map = new HashMap<String, Object>();
        if (!passowrd.equals(md5Password)){
            map.put("isSuccess",false);
            map.put("Msg","密码不正确！");
        }else {
            map.put("isSuccess",true);
        }
        return map;
    }

}
