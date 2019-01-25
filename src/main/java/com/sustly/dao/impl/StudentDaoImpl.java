package com.sustly.dao.impl;

import com.sustly.bean.StudentInfo;
import com.sustly.dao.StudentDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

    public void addStudent(StudentInfo st) {
        this.getHibernateTemplate().save(st);
    }

    public void updateStudent(StudentInfo st) {
        this.getHibernateTemplate().update(st);
    }

    public void deleteStudentByUuid(String uuid) {
        List<StudentInfo> list = (List<StudentInfo>) this.getHibernateTemplate().find("from StudentInfo where uuid=?0", uuid);
        StudentInfo info = list.get(0);
        this.getHibernateTemplate().delete(info);
    }

    public StudentInfo findStudentByName(String name) {
        DetachedCriteria criteria = DetachedCriteria.forClass(StudentInfo.class);
        criteria.add(Restrictions.eq("name",name));
        List<StudentInfo> list = (List<StudentInfo>) this.getHibernateTemplate().findByCriteria(criteria);
        return list.get(0);
    }

    public List<StudentInfo> findStudentByTeacherid(String id) {
        String hql = "from StudentInfo where teacherId=?0";
        List<StudentInfo> list = (List<StudentInfo>) this.getHibernateTemplate().find(hql,id);
        if (list==null || list.size()==0){
            return null;
        }else {
            return list;
        }
    }

    public void updateStudentByname(String name, Integer schoolId) {
        StudentInfo student = findStudentByName(name);
        student.setSchoolId(schoolId);
        this.getHibernateTemplate().update(student);
    }

    public void deleteStudentByName(String name) {
        StudentInfo student = findStudentByName(name);
        this.getHibernateTemplate().delete(student);
    }

    public List<StudentInfo> findStudentByUuid(String uuid) {
        DetachedCriteria criteria = DetachedCriteria.forClass(StudentInfo.class);
        criteria.add(Restrictions.eq("uuid",uuid));
        List<StudentInfo> list = (List<StudentInfo>) this.getHibernateTemplate().findByCriteria(criteria);
        return list;
    }
}
