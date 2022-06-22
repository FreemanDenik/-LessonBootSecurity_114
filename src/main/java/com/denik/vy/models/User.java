package com.denik.vy.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column
    private byte age;

    public User(String name, String lastname, byte age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public User() {

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("name: %s, lastname: %s, age: %d", name, lastname, age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        User user = (User) obj;
        if (this.id != user.id ||
                !this.name.equals(user.name) ||
                !this.lastname.equals(user.lastname) ||
                this.age != user.age) {
            return false;
        }
        return true;
    }
}
