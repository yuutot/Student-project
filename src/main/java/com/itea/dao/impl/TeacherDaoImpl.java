package com.itea.dao.impl;

import com.itea.dao.EntityDao;
import com.itea.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;


@Component
public class TeacherDaoImpl implements EntityDao<Teacher> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext(name = "student-unit")
    private EntityManager em;

    public void insert(Teacher value) {
        //EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        em.persist(value);
        //em.getTransaction().commit();
        em.close();
    }

    public Teacher find(long id) {
        EntityManager em = emf.createEntityManager();
        Teacher result = em.find(Teacher.class, id);
        em.close();
        return result;
    }
}
