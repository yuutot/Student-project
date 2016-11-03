package com.itea.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {


    @Id
    @GeneratedValue
    @Column(name = "TEACHER_ID")
    private long id;
    private String Name;
    private String Surname;
    private String Phone;
    private String email;
    private String password;
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        Teacher teacher = (Teacher) o;

        if (id != teacher.getId()) return false;
        if (Name != null ? !Name.equals(teacher.getName()) : teacher.Name != null) return false;
        if (Surname != null ? !Surname.equals(teacher.getSurname()) : teacher.Surname != null) return false;
        if (Phone != null ? !Phone.equals(teacher.getPhone()) : teacher.Phone != null) return false;
        return email != null ? email.equals(teacher.getEmail()) : teacher.email == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (Surname != null ? Surname.hashCode() : 0);
        result = 31 * result + (Phone != null ? Phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
