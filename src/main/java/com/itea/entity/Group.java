package com.itea.entity;

import javax.persistence.*;

@Entity
@Table(name = "SGROUP")
public class Group {
    @Id
    @Column(name = "GROUP_ID")
    private long Number;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "TEACHER_ID", nullable = false) //false
    private Teacher curator;

    public Group() {
    }

    public Group(long number, Teacher curator) {
        Number = number;
        this.curator = curator;
    }

    public String toString() {
        return "Group{" +
                "Number=" + Number +
                ", curator=" + curator +
                '}';
    }

    private long getNumber() {
        return Number;
    }

    public void setNumber(long number) {
        Number = number;
    }

    private Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Group group = (Group) o;

        if (Number != group.getNumber()) return false;
        return curator != null ? curator.equals(group.getCurator()) : group.curator == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (Number ^ (Number >>> 32));
        result = 31 * result + (curator != null ? curator.hashCode() : 0);
        return result;
    }
}
