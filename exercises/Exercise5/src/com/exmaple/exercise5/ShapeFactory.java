package com.exmaple.exercise5;

public class ShapeFactory {
    public Shape createShape(String shape) {
        if (shape == "Square") {
            return new Square();
        }
        if (shape == "Rectangle") {
            return new Rectangle();
        }
        return null;
    }
}
