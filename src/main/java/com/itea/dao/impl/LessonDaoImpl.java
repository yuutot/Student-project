package com.itea.dao.impl;

import com.itea.dao.EntityDao;
import com.itea.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Component
@Transactional
public class LessonDaoImpl implements EntityDao<Lesson> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    public void insert(Lesson value) {
        em.persist(value);
        em.close();
    }

    public Lesson find(long id) {
        Lesson result = em.find(Lesson.class, id);
        em.close();
        return result;
    }
}
