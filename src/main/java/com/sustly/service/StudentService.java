package com.sustly.service;

import com.sustly.bean.StudentInfo;

import java.util.List;

public interface StudentService {
    void addStudent(StudentInfo st);
    void updateStudent(StudentInfo st);
    void deleteStudentByUuid(String uuid);
    StudentInfo findStudentByName(String name);
    List<StudentInfo> findStudentByTeacherid(String id);
    void updateStudentByname(String name, Integer schoolId);

    void deleteStudentByName(String name);

    List<StudentInfo> findStudentByUuid(String uuid);
}
