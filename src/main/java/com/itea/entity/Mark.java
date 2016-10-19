package com.itea.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Mark {
    @Id
    @GeneratedValue
    @Column(name = "MARK_ID")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LESSON_ID", nullable = false)//false
    private Lesson lesson;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID", nullable = false)//false
    private Teacher teacher;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID", nullable = false)//false
    private Student student;
    private Integer mark;
    @Column(name ="Mark_Date")
    private Integer date;

    @Override
    public String toString() {
        return "Mark{" +
                "id=" + id +
                ", lesson=" + lesson +
                ", teacher=" + teacher +
                ", mark=" + mark +
                ", date=" + date +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Mark mark1 = (Mark) o;

        if (id != mark1.id) return false;
        if (lesson != null ? !lesson.equals(mark1.getLesson()) : mark1.lesson != null) return false;
        if (teacher != null ? !teacher.equals(mark1.getTeacher()) : mark1.teacher != null) return false;
        if (student != null ? !student.equals(mark1.getStudent()) : mark1.student != null) return false;
        if (mark != null ? !mark.equals(mark1.getMark()) : mark1.mark != null) return false;
        return date != null ? date.equals(mark1.getDate()) : mark1.date == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (lesson != null ? lesson.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (student != null ? student.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
