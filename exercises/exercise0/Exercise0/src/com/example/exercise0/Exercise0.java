package com.example.exercise0;

public class Exercise0 {
    public static void main(String[] args) {
        System.out.println("exercise0");
        for (int i = 0; i < 3; i++) {
            Bag bag = new Bag(i);
            Bottle bottle = new Bottle(i);
            Chair chair = new Chair(i);
            Charger charger = new Charger(i);
            Desk desk = new Desk(i);
            Desktop desktop = new Desktop(i);
            Laptop laptop = new Laptop(i);
            Monitor monitor = new Monitor(i);
            Phone phone = new Phone(i);
            TV tv = new TV(i);
        }
    }
}
