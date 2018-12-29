package com.sinuonan.dao.impl;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.bean.TeacherInfo;
import com.sinuonan.dao.TeacherDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao {
    public String findPassowrdByid(String id) {
        String hql = "select password from TeacherInfo where id="+"'"+id+"'";
        List<String> list = (List<String>) this.getHibernateTemplate().find(hql);
        if (list==null || list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }

    public void save(TeacherInfo info) {
        this.getHibernateTemplate().save(info);
    }

}
