package com.example.exercise1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Session {
    public Session() {
        students = new Student[20];
    }
    public void calculateAverageQuizScores() {
        System.out.println("calculateAverageQuizScores");
        for (int i = 0; i < students.length; i++) {
            float avgScore = 0.0f;
            for (int j = 0; j < students[i].quizzes.length; j++) {
                avgScore += students[i].quizzes[j];
            }
            avgScore /= students[i].quizzes.length;
            System.out.println(avgScore);
        }
    }
    public void printQuizScores() {
        int numStudents = students.length;
        float quizes[] = new float[numStudents * 15];
        int k = 0;
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students[i].quizzes.length; j++) {
                quizes[k++] = students[i].quizzes[j];
            }
        }
        Arrays.sort(quizes);
        System.out.println("printQuizScores");
        for (int i = 0; i < quizes.length; i++) {
            System.out.println(quizes[i]);
        }
    }

    public void printNamesForPartTime() {
        System.out.println("printNamesForPartTime");
        for (int i = 0; i < students.length; i++) {
            if (students[i] instanceof PartTime) {
                System.out.println(students[i].getName());
            }
        }
    }
    public void printExamScoresForFullTime() {
        System.out.println("printExamScoresForFullTime");
        for (int i = 0; i < students.length; i++) {
            if (students[i] instanceof FullTime) {
                FullTime fulltime = (FullTime)students[i];
                System.out.println("exam1 " + fulltime.getExam1() + " exam2 " + fulltime.getExam2());
            }
        }
    }
    public Student students[];
}
