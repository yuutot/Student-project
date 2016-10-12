package com.itea.entity;

import javax.persistence.*;

@Entity
public class Lesson {
    @Id
    @GeneratedValue
    @Column(name = "LESSON_ID")
    private Long id;
    private String title;
    private String room;

    public Lesson() {
    }
    public Lesson(String title, String room, Group sgroup, Teacher teacher) {
        this.title = title;
        this.room = room;
        this.sgroup = sgroup;
        this.teacher = teacher;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)

    @JoinColumn(name = "GROUP_ID", nullable =true)//false
    private Group sgroup;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "TEACHER_ID", nullable = true)//false
    private Teacher teacher;

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", room='" + room + '\'' +
                ", group=" + sgroup +
                ", teacher=" + teacher +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Group getGroup() {
        return sgroup;
    }

    public void setGroup(Group group) {
        this.sgroup = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getSgroup() {
        return sgroup;
    }

    public void setSgroup(Group sgroup) {
        this.sgroup = sgroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Lesson lesson = (Lesson) o;

        if (id != null ? !id.equals(lesson.getId()) : lesson.id != null) return false;
        if (title != null ? !title.equals(lesson.getTitle()) : lesson.title != null) return false;
        if (room != null ? !room.equals(lesson.getRoom()) : lesson.room != null) return false;
        if (sgroup != null ? !sgroup.equals(lesson.getGroup()) : lesson.sgroup != null) return false;
        return teacher != null ? teacher.equals(lesson.getTeacher()) : lesson.teacher == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (sgroup != null ? sgroup.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }
}
