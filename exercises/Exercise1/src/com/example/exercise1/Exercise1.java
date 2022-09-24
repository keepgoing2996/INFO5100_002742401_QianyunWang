package com.example.exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        Session session = new Session();
        int numFullTime = 5;
        int numPartTime = 15;
        int totalStudents = 20;
        String namesFullTime[] = new String[] { "F1", "F2", "F3", "F4", "F5" };
        String namesPartTime[] = new String[] { "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "P11", "P12", "P13", "P14", "P15" };

        for (int i = 0; i < numPartTime; i++) {
            PartTime partime = new PartTime(namesPartTime[i]);
            session.students[i] = partime;
        }

        for (int i = 0; i < numFullTime; i++) {
            FullTime fulltime = new FullTime(namesFullTime[i]);
            fulltime.exam1 = 80.f;
            fulltime.exam2 = 90.f;
            session.students[i + numPartTime] = fulltime;
        }

        for (int i = 0; i < totalStudents; i++) {
            for (int j = 0; j < session.students[i].quizzes.length; j++) {
                session.students[i].quizzes[j] = i * 5 + (float)(j) / 10;
            }
        }


        session.printExamScoresForFullTime();
        session.printNamesForPartTime();
        session.calculateAverageQuizScores();
        session.printQuizScores();


    }
}
