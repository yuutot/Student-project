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

    @Override
    public List<Teacher> getAllTeachers() {
        return em.createQuery("select e from "+Teacher.class.getName()+" e").getResultList();
    }

    @Override
    public List<Lesson> getAllLessons() {
        return em.createQuery("select e from "+Lesson.class.getName()+" e").getResultList();
    }

    public List<Student> getStudentByGroup(long groupId) {
        return em.createQuery("select e from "+Student.class.getName()+" e where GROUP_ID = "+groupId).getResultList();
    }


    public List<Mark> getMarksByStudent(long studentId, long lessonId) {
        return em.createQuery("select e from "+Mark.class.getName()+" e where STUDENT_ID = "+studentId + " and LESSON_ID = " +lessonId).getResultList();
    }

    @Override
    public List<Lesson> getLessonsByGroup(long groupId) {
        return em.createQuery("select e from "+Lesson.class.getName()+" e where GROUP_ID = "+groupId).getResultList();
    }

    @Override
    public List<Lesson> getLessonsByTeacher(long teacherId, long groupId) {
        return em.createQuery("select e from "+Lesson.class.getName()+" e where TEACHER_ID = "+teacherId + " and GROUP_ID = "+groupId).getResultList();
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
        em.close();
    }

    public void insertGroup(Group group) {
        em.persist(group);
        em.close();
    }

    public Mark findMark(long id) {
        Mark result = em.find(Mark.class, id);
        em.close();
        return result;
    }

    @Override
    public Teacher findTeacher(long id) {
        Teacher result = em.find(Teacher.class, id);
        em.close();
        return result;
    }

    @Override
    public Group findGroup(long id) {
        Group result = em.find(Group.class, id);
        em.close();
        return result;
    }

    @Override
    public Student findStudent(long id) {
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }

    @Override
    public Lesson findLesson(long id) {
        Lesson lesson = em.find(Lesson.class, id);
        em.close();
        return lesson;
    }

    @Override
    public Teacher getTeacherByPassword(String email, String password) {
        List<Teacher> teachers= em.createQuery("select e from "+Teacher.class.getName()+" e where EMAIL = '"+email + "' and PASSWORD = '" +password+"'").getResultList();
        if(teachers.size() == 0) return null;
        else return teachers.get(0);
    }

    @Override
    public Student getStudentByPassword(String email, String password) {
        List<Student> students= em.createQuery("select e from "+Student.class.getName()+" e where EMAIL = '"+email + "' and PASSWORD = '" +password+"'").getResultList();
        if(students.size() == 0) return null;
        else return students.get(0);
    }
}
