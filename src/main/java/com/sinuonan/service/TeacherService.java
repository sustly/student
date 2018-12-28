package com.sinuonan.service;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.bean.TeacherInfo;

import java.util.List;

public interface TeacherService {
    String findPassowrdByid(String id);
    void save(TeacherInfo info);
    List<StudentInfo> findStudentByTeacherid(String id);
}
