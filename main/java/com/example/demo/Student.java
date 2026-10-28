package com.example.demo;
public class Student {

    // Private instance variables
    private String name;
    private int age;
    private boolean present;

    // Constructor
    public Student(String name, int age, boolean present) {
        this.name = name;
        this.age = age;
        this.present = present;
    }

    // =========================
    // GETTERS
    // =========================

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isPresent() {
        return present;
    }

    // =========================
    // SETTERS
    // =========================

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}