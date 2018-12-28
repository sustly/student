package com.sinuonan.dao.impl;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.bean.TeacherInfo;
import com.sinuonan.dao.TeacherDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author liyue
 * @date 2018/12/28 14:17
 */
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

    public List<StudentInfo> findStudentByTeacherid(String id) {
        String hql = "from StudentInfo where teacherId="+"'"+id+"'";
        List<StudentInfo> list = (List<StudentInfo>) this.getHibernateTemplate().find(hql);
        if (list==null || list.size()==0){
            return null;
        }else {
            return list;
        }
    }
}
