package com.itea.dao;

import com.itea.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class EntityDaoImpl implements EntityDao {

    @PersistenceContext
    private EntityManager em;

    public List<Group> getAllGroups() {
        return em.createQuery("select e from "+Group.class.getName()+" e").getResultList();
    }

    public List<Student> getStudentByGroup(long groupId) {
        return em.createQuery("select e from "+Student.class.getName()+" e where GROUP_ID = "+groupId).getResultList();
    }

    public Student getStudent(long studentId) {
        Student result = em.find(Student.class, studentId);
        em.close();
        return result;
    }

    public List<Mark> getMarksByStudent(long studentId) {
        return em.createQuery("select e from "+Mark.class.getName()+" e where STUDENT_ID = "+studentId).getResultList();
    }

    public void insertMark(Mark mark) {
        em.persist(mark);
        em.close();
    }

    public void insertStudent(Student student) {
        em.persist(student);
        em.close();
    }

    public void insertLesson(Lesson lesson) {
        em.persist(lesson);
        em.close();
    }

    public void insertTeacher(Teacher teacher) {
        em.persist(teacher);
    }

    public void insertGroup(Group group) {
        em.persist(group);
    }

    public Mark findMark(long id) {
        Mark result = em.find(Mark.class, id);
        em.close();
        return result;
    }
}
