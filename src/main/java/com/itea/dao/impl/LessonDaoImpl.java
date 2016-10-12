package com.itea.dao.impl;

import com.itea.dao.EntityDao;
import com.itea.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by yuuto on 10/9/16.
 */
@Component
public class LessonDaoImpl implements EntityDao<Lesson> {

    @Autowired
    private EntityManagerFactory emf;
    public void insert(Lesson value) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(value);
        em.getTransaction().commit();
        em.close();
    }

    public Lesson find(long id) {
        EntityManager em = emf.createEntityManager();
        Lesson result = em.find(Lesson.class, id);
        em.close();
        return result;
    }
}
