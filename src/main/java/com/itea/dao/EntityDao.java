package com.itea.dao;

import com.itea.entity.*;

import java.util.List;

public interface EntityDao {
    List<Group> getAllGroups();
    List<Teacher> getAllTeachers();
    List<Lesson> getAllLessons();
    List<Lesson> getLessonsByGroup(long groupId);
    List<Lesson> getLessonsByTeacher(long teacherId, long groupId);
    List<Student> getStudentByGroup(long groupId);
    List<Mark> getMarksByStudent(long studentId, long lessonId);
    void insertMark(Mark mark);
    void insertStudent(Student student);
    void insertLesson(Lesson lesson);
    void insertTeacher(Teacher teacher);
    void insertGroup(Group group);
    Mark findMark(long id);
    Teacher findTeacher(long id);
    Group findGroup(long id);
    Student findStudent(long id);
    Lesson findLesson(long id);
    Teacher getTeacherByPassword(String email, String password);
    Student getStudentByPassword(String email, String password);
}
