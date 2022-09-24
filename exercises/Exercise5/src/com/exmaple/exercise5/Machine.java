package com.exmaple.exercise5;

public class Machine {
    private static Machine machine = new Machine();

    private Machine() {}

    public static Machine getMachine() {
        return machine;
    }

    public void doWork() {
        System.out.println("do job");
    }
}
