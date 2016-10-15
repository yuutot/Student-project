package com.itea.dao.impl;

import com.itea.dao.EntityDao;
//import com.itea.entity.Group;
import com.itea.entity.Group;

import com.itea.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Component
@Transactional
public class GroupDaoImpl implements EntityDao<Group> {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;
    public void insert(Group value) {
        em.persist(value);
        em.close();
    }

    public Group find(long id) {
        Group result = em.find(Group.class, id);
        em.close();
        return result;
    }
}
