package com.itea.dao.impl;

import com.itea.dao.EntityDao;
import com.itea.entity.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Component("MarkDao")
@Transactional
public class MarkDaoImpl implements EntityDao<Mark> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    public void insert(Mark value) {
        em.persist(value);
        em.close();
    }

    public Mark find(long id) {
        Mark result = em.find(Mark.class, id);
        em.close();
        return result;
    }
}
