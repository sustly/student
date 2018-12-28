package com.sinuonan.dao;

import com.sinuonan.bean.StudentInfo;

public interface StudentDao {
    void addStudent(StudentInfo st);
    void updateStudent(StudentInfo st);
    void deleteStudentByUuid(String uuid);
    StudentInfo findStudentByName(String name);
}
