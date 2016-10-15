package com.itea.entity;

import javax.persistence.*;

@Entity
public class Student {

    public Student() {
    }
    public Student(String name, String surname, Group sgroup, Integer tickets, String email, Integer number) {
        Name = name;
        Surname = surname;
        this.sgroup = sgroup;
        this.tickets = tickets;
        this.email = email;
        this.number = number;
    }

    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    private Long id;
    private String Name;
    private String Surname;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID", nullable = false)//false
    private Group sgroup;
    private Integer tickets;
    private String email;
    @Column(name = "PHONE")
    private Integer number;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
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

        if (id != null ? !id.equals(student.getId()) : student.id != null) return false;
        if (Name != null ? !Name.equals(student.getName()) : student.Name != null) return false;
        if (Surname != null ? !Surname.equals(student.getSurname()) : student.Surname != null) return false;
        if (sgroup != null ? !sgroup.equals(student.getGroup()) : student.sgroup != null) return false;
        if (tickets != null ? !tickets.equals(student.getTickets()) : student.tickets != null) return false;
        if (email != null ? !email.equals(student.getEmail()) : student.email != null) return false;
        return number != null ? number.equals(student.getNumber()) : student.number == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (Surname != null ? Surname.hashCode() : 0);
        result = 31 * result + (sgroup != null ? sgroup.hashCode() : 0);
        result = 31 * result + (tickets != null ? tickets.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
