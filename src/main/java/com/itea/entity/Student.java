package com.itea.entity;

import javax.persistence.*;

@Entity
public class Student extends User {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", nullable = false)//false
    private Group sgroup;
    private Integer tickets;
    @Column(name = "PHONE")
    private Integer number;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", group=" + sgroup +
                ", tickets=" + tickets +
                ", email='" + email + '\'' +
                ", number=" + number +
                '}';
    }

    public Group getGroup() {
        return sgroup;
    }

    public void setGroup(Group group) {
        this.sgroup = group;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

        Student student = (Student) o;

        if (id != student.getId()) return false;
        if (name != null ? !name.equals(student.getName()) : student.name != null) return false;
        if (surname != null ? !surname.equals(student.getSurname()) : student.surname != null) return false;
        if (sgroup != null ? !sgroup.equals(student.getGroup()) : student.sgroup != null) return false;
        if (tickets != null ? !tickets.equals(student.getTickets()) : student.tickets != null) return false;
        if (email != null ? !email.equals(student.getEmail()) : student.email != null) return false;
        return number != null ? number.equals(student.getNumber()) : student.number == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (sgroup != null ? sgroup.hashCode() : 0);
        result = 31 * result + (tickets != null ? tickets.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
