package com.itea.entity;

import javax.persistence.*;

@Entity
public class Lesson {
    @Id
    @GeneratedValue
    @Column(name = "LESSON_ID")
    private long id;
    private String title;
    private String room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", nullable =false)//false
    private Group group;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID", nullable = false)//false
    private Teacher teacher;

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", room='" + room + '\'' +
                ", group=" + group +
                ", teacher=" + teacher +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        Lesson lesson = (Lesson) o;

        if (id != lesson.getId()) return false;
        if (title != null ? !title.equals(lesson.getTitle()) : lesson.title != null) return false;
        if (room != null ? !room.equals(lesson.getRoom()) : lesson.room != null) return false;
        if (group != null ? !group.equals(lesson.getGroup()) : lesson.group != null) return false;
        return teacher != null ? teacher.equals(lesson.getTeacher()) : lesson.teacher == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }
}
