package com.itea.dao.impl;

import com.itea.dao.EntityDao;
//import com.itea.entity.Group;
import com.itea.entity.Group;

import com.itea.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by yuuto on 10/9/16.
 */
@Component
public class GroupDaoImpl implements EntityDao<Group> {

    @Autowired
    private EntityManagerFactory emf;
    public void insert(Group value) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(value);
        em.getTransaction().commit();
        em.close();
    }

    public Group find(long id) {
        EntityManager em = emf.createEntityManager();
        Group result = em.find(Group.class, id);
        em.close();
        return result;
    }
}
