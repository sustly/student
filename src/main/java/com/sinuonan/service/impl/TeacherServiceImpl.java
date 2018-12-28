package com.sinuonan.service.impl;

import com.sinuonan.dao.TeacherDao;
import com.sinuonan.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liyue
 * @date 2018/12/28 14:53
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource(name = "teacherDao")
    private TeacherDao dao;

    public String findPassowrdByid(String id) {
        return dao.findPassowrdByid(id);
    }
}
