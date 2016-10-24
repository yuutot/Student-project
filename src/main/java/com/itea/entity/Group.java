package com.itea.entity;

import javax.persistence.*;

@Entity
@Table(name = "SGROUP")
public class Group {
    @Id
    @Column(name = "GROUP_ID")
    private long Number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID", nullable = false) //false
    private Teacher curator;

    public String toString() {
        return "Group{" +
                "Number=" + Number +
                ", curator=" + curator +
                '}';
    }

    public long getNumber() {
        return Number;
    }

    public void setNumber(long number) {
        Number = number;
    }

    public Teacher getCurator() {
        return curator;
    }

    public void setCurator(Teacher curator) {
        this.curator = curator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
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
