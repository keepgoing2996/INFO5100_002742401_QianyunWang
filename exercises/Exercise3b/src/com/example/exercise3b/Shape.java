package com.example.exercise3b;

public abstract class Shape implements java.io.Serializable {
    int x = 5;
    int y = 10;
    abstract double calculateArea();
    abstract double calculatePerimeter();
}
