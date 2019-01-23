package com.sinuonan.controller;

import com.sinuonan.bean.TeacherInfo;
import com.sinuonan.service.TeacherService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
            return "redirect:/login";
        }else {
            return "redirect:/register";
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/checkId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkId(@RequestBody String param){
        JSONObject jsonObject = new JSONObject(param);
        String username = (String) jsonObject.get("username");
        String passWord = service.findPassowrdByid(username);
        Map<String, Object> map = new HashMap<String, Object>();
        if (passWord == null){
            map.put("isSuccess",true);
            map.put("Msg","keyong");
        }else {
            map.put("isSuccess",false);
        }

        return map;
    }

}
