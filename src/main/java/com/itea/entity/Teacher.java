package com.itea.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {


    @Id
    @GeneratedValue
    @Column(name = "TEACHER_ID")
    private Long id;
    private String Name;
    private String Surname;
    private String Phone;
    private String Email;

    public Teacher() {
    }
    public Teacher(String name, String surname, String phone, String email) {
        Name = name;
        Surname = surname;
        Phone = phone;
        Email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                '}';
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        Teacher teacher = (Teacher) o;

        if (id != null ? !id.equals(teacher.getId()) : teacher.id != null) return false;
        if (Name != null ? !Name.equals(teacher.getName()) : teacher.Name != null) return false;
        if (Surname != null ? !Surname.equals(teacher.getSurname()) : teacher.Surname != null) return false;
        if (Phone != null ? !Phone.equals(teacher.getPhone()) : teacher.Phone != null) return false;
        return Email != null ? Email.equals(teacher.getEmail()) : teacher.Email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (Surname != null ? Surname.hashCode() : 0);
        result = 31 * result + (Phone != null ? Phone.hashCode() : 0);
        result = 31 * result + (Email != null ? Email.hashCode() : 0);
        return result;
    }
}
