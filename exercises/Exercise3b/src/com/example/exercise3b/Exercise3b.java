package com.example.exercise3b;
import java.io.*;
public class Exercise3b {
    public static void main(String[] args) {
        System.out.println("haha");
        System.out.println("hello");
        Shape sc = new Circle();
        Shape sr = new Rectangle();
        Shape ss = new Square();
        Shape st = new Triangle();

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/circle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sc);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/circle.ser\n");
        } catch (IOException i) {
            i.printStackTrace();
        }

        Circle sc_d = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/circle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sc_d = (Circle) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println(" class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Circle...");
        System.out.println("x: " + sc_d.x);
        System.out.println("y: " + sc_d.y);
        System.out.println("name: " + sc_d.name);


        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/rectangle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(sr);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/rectangle.ser\n");
        } catch (IOException i) {
            i.printStackTrace();
        }

        Rectangle sr_d = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/rectangle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sr_d = (Rectangle) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println(" class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Circle...");
        System.out.println("x: " + sr_d.x);
        System.out.println("y: " + sr_d.y);
        System.out.println("name: " + sr_d.name);


        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/square.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(ss);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/square.ser\n");
        } catch (IOException i) {
            i.printStackTrace();
        }

        Square ss_d = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/square.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ss_d = (Square) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println(" class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized square...");
        System.out.println("x: " + ss_d.x);
        System.out.println("y: " + ss_d.y);
        System.out.println("name: " + ss_d.name);

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/triangle.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(st);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/triangle.ser\n");
        } catch (IOException i) {
            i.printStackTrace();
        }

        Triangle st_d = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/triangle.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            st_d = (Triangle) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println(" class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized triangle...");
        System.out.println("x: " + st_d.x);
        System.out.println("y: " + st_d.y);
        System.out.println("name: " + st_d.name);

    }
}
