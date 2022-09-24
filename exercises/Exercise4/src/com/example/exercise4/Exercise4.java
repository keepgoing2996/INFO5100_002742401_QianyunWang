package com.example.exercise4;
import java.util.regex.*;

public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("case 1");
        String regex1 = "[ade]";
        System.out.println(Pattern.matches(regex1, "d"));
        System.out.println(Pattern.matches(regex1, "bade3"));

        System.out.println("case 2");
        String regex2 = "[ade]+";
        System.out.println(Pattern.matches(regex2, "aed"));
        System.out.println(Pattern.matches(regex2, "acd"));

        System.out.println("case 3");
        String regex3 = "[1-9][0-9]{9}";
        System.out.println(Pattern.matches(regex3, "4125096168"));
        System.out.println(Pattern.matches(regex3, "0125096168"));

        System.out.println("case 4");
        String regex4 = "[\\w]+\\@[\\w]+.com";
        System.out.println(Pattern.matches(regex4, "zha@gmail.com"));
        System.out.println(Pattern.matches(regex4, "zha@gmail.cn"));

        System.out.println("case 5");
        String regex5 = "[JH]ello";
        System.out.println(Pattern.matches(regex5, "Hello"));
        System.out.println(Pattern.matches(regex5, "jello"));


    }
}
