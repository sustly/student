package com.sinuonan.service;

import com.sinuonan.bean.TeacherInfo;

public interface TeacherService {
    String findPassowrdByid(String id);
    void save(TeacherInfo info);
}
