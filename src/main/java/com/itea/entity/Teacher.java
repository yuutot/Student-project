package com.itea.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher extends User{
    private String Phone;
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
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
        if (name != null ? !name.equals(teacher.getName()) : teacher.name != null) return false;
        if (surname != null ? !surname.equals(teacher.getSurname()) : teacher.surname != null) return false;
        if (Phone != null ? !Phone.equals(teacher.getPhone()) : teacher.Phone != null) return false;
        return email != null ? email.equals(teacher.getEmail()) : teacher.email == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (Phone != null ? Phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
