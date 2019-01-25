package com.sustly.dao;

import com.sustly.bean.TeacherInfo;

public interface TeacherDao {
    String findPassowrdByid(String id);
    void save(TeacherInfo info);
}
