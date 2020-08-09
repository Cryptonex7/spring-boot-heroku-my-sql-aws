package com.anujeetchatterjee.sqlmsqlv2.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CITIZEN_TABLE")
public class Citizen {
    @Id
    @GeneratedValue
    @NotNull
    private int id;
    private int age;
    private String name;

    public Citizen(String name, int age, char gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    private char gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

}
