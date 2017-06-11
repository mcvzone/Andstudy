package com.example.neo.andstudy;

import java.io.Serializable;

/**
 * Created by neo on 2017-06-11.
 */

public class Person implements Serializable{

    String name;
    int age;

    public Person(){

    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
