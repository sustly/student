package com.sinuonan.dao.impl;

import com.sinuonan.dao.TeacherDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyue
 * @date 2018/12/28 14:17
 */
public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao {
    public String findPassowrdByid(String id) {
        List<String> list = (List<String>) this.getHibernateTemplate().find("select password from TeacherInfo where id=?0", "'"+id+"'");
        if (list==null || list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }
}
