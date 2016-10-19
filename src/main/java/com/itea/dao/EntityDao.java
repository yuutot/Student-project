package com.itea.dao;

import com.itea.entity.*;

import java.util.List;

public interface EntityDao {
    List<Group> getAllGroups();
    List<Student> getStudentByGroup(long groupId);
    Student getStudent(long studentId);
    List<Mark> getMarksByStudent(long studentId);
    void insertMark(Mark mark);
    void insertStudent(Student student);
    void insertLesson(Lesson lesson);
    void insertTeacher(Teacher teacher);
    void insertGroup(Group group);
    Mark findMark(long id);

}
