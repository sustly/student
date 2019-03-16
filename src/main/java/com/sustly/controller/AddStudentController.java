package com.sustly.controller;

import com.sustly.bean.StudentInfo;
import com.sustly.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 添加学生信息
 * 该类中的字段与jsp页面一一对应，可接收jsp请求的参数
 */
@Controller
public class AddStudentController {

    @Resource(name = "StudentService")
    private StudentService service;

    /**
     * 添加学生
     * @return view
     */
    @RequestMapping(value = "/addStudent_submit",method = RequestMethod.POST)
    public String addStudent(@RequestParam("name") String name,
                             @RequestParam("gender") String gender,
                             @RequestParam("className") String className,
                             @RequestParam("schoolId") Integer schoolId,
                             Map<String,Object> map,
                             HttpSession session){
        StudentInfo info = new StudentInfo();
        info.setClassName(className);
        info.setGender(gender);
        info.setSchoolId(schoolId);
        info.setName(name);
        String id = (String) session.getAttribute("id");
        info.setTeacherId(id);
        info.setUuid(UUID.randomUUID().toString());

        service.addStudent(info);

        List<StudentInfo> list = service.findStudentByTeacherid(id);
        map.put("list",list);

        return "student_list";
    }
}
