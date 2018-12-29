package com.sinuonan.dao.impl;

import com.sinuonan.bean.StudentInfo;
import com.sinuonan.dao.StudentDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @author liyue
 * @date 2018/12/28 11:06
 */
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

    public void addStudent(StudentInfo st) {
        this.getHibernateTemplate().save(st);
    }

    public void updateStudent(StudentInfo st) {
        this.getHibernateTemplate().update(st);
    }

    public void deleteStudentByUuid(String uuid) {
        List<StudentInfo> list = (List<StudentInfo>) this.getHibernateTemplate().find("from StudentInfo where uuid=?", uuid);
        StudentInfo info = list.get(0);
        this.getHibernateTemplate().delete(info);
    }

    public StudentInfo findStudentByName(String name) {
        List<StudentInfo> list = (List<StudentInfo>) this.getHibernateTemplate().find("from StudentInfo where name=?", name);
        StudentInfo info = list.get(0);
        return info;
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
