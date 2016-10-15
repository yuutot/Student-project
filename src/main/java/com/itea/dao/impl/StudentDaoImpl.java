package com.itea.dao.impl;

import com.itea.dao.EntityDao;
import com.itea.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Component
@Transactional
public class StudentDaoImpl implements EntityDao<Student> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;
    public void insert(Student value) {
        em.persist(value);
        em.close();
    }

    public Student find(long id) {
        Student result = em.find(Student.class, id);
        em.close();
        return result;
    }
}
