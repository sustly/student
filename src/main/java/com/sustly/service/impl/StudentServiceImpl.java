package com.sustly.service.impl;

import com.sustly.bean.StudentInfo;
import com.sustly.dao.StudentDao;
import com.sustly.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<StudentInfo> findStudentByTeacherid(String id) {
        return dao.findStudentByTeacherid(id);
    }

    public void updateStudentByname(String name, Integer schoolId) {
        dao.updateStudentByname(name, schoolId);
    }

    public void deleteStudentByName(String name) {
        dao.deleteStudentByName(name);
    }

    public List<StudentInfo> findStudentByUuid(String uuid) {
        return dao.findStudentByUuid(uuid);
    }


}
