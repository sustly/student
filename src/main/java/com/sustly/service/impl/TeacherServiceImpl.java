package com.sustly.service.impl;

import com.sustly.bean.TeacherInfo;
import com.sustly.dao.TeacherDao;
import com.sustly.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {
    @Resource(name = "teacherDao")
    private TeacherDao dao;

    public String findPassowrdByid(String id) {
        return dao.findPassowrdByid(id);
    }

    public void save(TeacherInfo info) {
        dao.save(info);
    }

}
