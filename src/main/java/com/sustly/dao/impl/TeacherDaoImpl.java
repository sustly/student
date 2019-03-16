package com.sustly.dao.impl;

import com.sustly.bean.TeacherInfo;
import com.sustly.dao.TeacherDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

@SuppressWarnings("unchecked")
public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao {
    public String findPassowrdByid(String id) {
        String hql = "select password from TeacherInfo where id=?0";
        List<String> list = (List<String>) this.getHibernateTemplate().find(hql,id);
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
