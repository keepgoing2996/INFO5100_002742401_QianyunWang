package com.example.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("hello");
        Shape sc = new Circle();
        Shape sr = new Rectangle();
        Shape ss = new Square();
        Shape st = new Triangle();
        System.out.println(sc.calculateArea() + " " + sc.calculatePerimeter() + " " + Circle.name);
        System.out.println(sr.calculateArea() + " " + sr.calculatePerimeter() + " " + Rectangle.name);
        System.out.println(ss.calculateArea() + " " + ss.calculatePerimeter() + " " + Square.name);
        System.out.println(st.calculateArea() + " " + st.calculatePerimeter() + " " + Triangle.name);
    }

}
