package com.sinuonan.controller;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class DeleteController {
    @Resource(name = "StudentService")
    private StudentService service;

    @RequestMapping(value = "/deleteByName",method = RequestMethod.GET)
    public String deleteByName(@RequestParam("name") String name,
                               Map<String,Object> map,
                               @ModelAttribute(value = "id") String id){
        service.deleteStudentByName(name);
        List<StudentInfo> list = service.findStudentByTeacherid(id);
        map.put("list",list);
        return "student_list";
    }
}
