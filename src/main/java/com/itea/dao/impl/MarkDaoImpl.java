package com.itea.dao.impl;

import com.itea.dao.EntityDao;
import com.itea.entity.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by yuuto on 10/9/16.
 */
@Component
public class MarkDaoImpl implements EntityDao<Mark> {

    @Autowired
    private EntityManagerFactory emf;
    public void insert(Mark value) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(value);
        em.getTransaction().commit();
        em.close();
    }

    public Mark find(long id) {
        EntityManager em = emf.createEntityManager();
        Mark result = em.find(Mark.class, id);
        em.close();
        return result;
    }
}
