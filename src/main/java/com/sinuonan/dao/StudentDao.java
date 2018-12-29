package com.sinuonan.dao;

import com.sinuonan.bean.StudentInfo;

import java.util.List;

public interface StudentDao {
    void addStudent(StudentInfo st);
    void updateStudent(StudentInfo st);
    void deleteStudentByUuid(String uuid);
    StudentInfo findStudentByName(String name);
    List<StudentInfo> findStudentByTeacherid(String id);
}
