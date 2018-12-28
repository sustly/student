package com.sinuonan.service;

import com.sinuonan.bean.StudentInfo;

public interface StudentService {
    void addStudent(StudentInfo st);
    void updateStudent(StudentInfo st);
    void deleteStudentByUuid(String uuid);
    StudentInfo findStudentByName(String name);
}
