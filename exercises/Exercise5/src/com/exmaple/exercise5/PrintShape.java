package com.exmaple.exercise5;
import java.util.*;
public class PrintShape extends Shape{
    private List<Shape> shapes = new ArrayList<Shape>();

    public void print() {
        int numS = shapes.size();
        for (int i = 0; i < numS; i++) {
            shapes.get(i).print();
        }
    }
    public void addShape(Shape s) {
        shapes.add(s);
    }
}
