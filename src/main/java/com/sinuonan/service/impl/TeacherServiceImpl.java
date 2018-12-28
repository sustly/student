package com.sinuonan.service.impl;

import com.sinuonan.bean.TeacherInfo;
import com.sinuonan.dao.TeacherDao;
import com.sinuonan.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @author liyue
 * @date 2018/12/28 14:53
 */
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
