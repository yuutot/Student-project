package com.itea.dao.impl;

import com.itea.dao.EntityDao;
import com.itea.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;


@Component
@Transactional
public class TeacherDaoImpl implements EntityDao<Teacher> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    public void insert(Teacher value) {
        em.persist(value);
        em.close();
    }

    public Teacher find(long id) {
        Teacher result = em.find(Teacher.class, id);
        em.close();
        return result;
    }
}
