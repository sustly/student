package com.sinuonan.service.impl;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.dao.StudentDao;
import com.sinuonan.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @author liyue
 * @date 2018/12/28 13:07
 */
@Service("StudentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Resource(name = "StudentDao")
    private StudentDao dao;

    public void addStudent(StudentInfo st) {
        dao.addStudent(st);
    }

    public void updateStudent(StudentInfo st) {
        dao.updateStudent(st);
    }

    public void deleteStudentByUuid(String uuid) {
        dao.deleteStudentByUuid(uuid);
    }

    public StudentInfo findStudentByName(String name) {
        return dao.findStudentByName(name);
    }
}
