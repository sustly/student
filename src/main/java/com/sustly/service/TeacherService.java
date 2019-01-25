package com.sustly.service;

import com.sustly.bean.TeacherInfo;

public interface TeacherService {
    String findPassowrdByid(String id);
    void save(TeacherInfo info);
}
