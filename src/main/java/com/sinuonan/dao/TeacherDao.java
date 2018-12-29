package com.sinuonan.dao;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.bean.TeacherInfo;

import java.util.List;

public interface TeacherDao {
    String findPassowrdByid(String id);
    void save(TeacherInfo info);
}
