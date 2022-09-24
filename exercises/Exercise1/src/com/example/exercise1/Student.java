package com.example.exercise1;

public class Student {

    public Student(String name) {
        this.name = name;
        quizzes = new float[15];
    }
    public String getName() {
        return name;
    }
    public float quizzes[];
    public String name;
}
