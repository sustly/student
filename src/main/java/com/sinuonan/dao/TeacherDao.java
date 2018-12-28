package com.sinuonan.dao;

import com.sinuonan.bean.TeacherInfo;

public interface TeacherDao {
    String findPassowrdByid(String id);
    void save(TeacherInfo info);
}
