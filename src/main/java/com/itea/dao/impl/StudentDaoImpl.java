package com.itea.dao.impl;

import com.itea.dao.EntityDao;
import com.itea.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by yuuto on 10/9/16.
 */
@Component
public class StudentDaoImpl implements EntityDao<Student> {

    @Autowired
    private EntityManagerFactory emf;
    public void insert(Student value) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(value);
        em.getTransaction().commit();
        em.close();
    }

    public Student find(long id) {
        EntityManager em = emf.createEntityManager();
        Student result = em.find(Student.class, id);
        em.close();
        return result;
    }
}
