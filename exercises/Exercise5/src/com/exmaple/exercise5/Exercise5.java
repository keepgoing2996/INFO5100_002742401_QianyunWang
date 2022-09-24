package com.exmaple.exercise5;

import javax.crypto.Mac;

public class Exercise5 {
    public static void main(String[] args) {
        // 1 Factory Method pattern
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape A = shapeFactory.createShape("Square");
        Shape B = shapeFactory.createShape("Rectangle");
        A.print();
        B.print();

        // 2 Singleton pattern
        Machine machine = Machine.getMachine();
        machine.doWork();
        Machine machine2 = Machine.getMachine();
        machine2.doWork();
        if (machine == machine2) {
            System.out.println("same machine");
        }

        // 3 Composite pattern
        PrintShape printShape = new PrintShape();
        printShape.addShape(A);
        printShape.addShape(B);
        printShape.print();


    }
}
