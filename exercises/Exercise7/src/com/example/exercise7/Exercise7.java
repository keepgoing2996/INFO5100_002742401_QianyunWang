package com.example.exercise7;

import java.util.*;
import java.util.Iterator;
import java.util.function.*;
public class Exercise7 {
    public static <E> int CountIf(Collection<E> collection, Predicate<E> property) {
        int cnt = 0;
        for (E ele: collection) {
            if (property.test(ele)) {
                cnt++;
            }
        }
        return cnt;
    }
    public class Property {
        public static boolean checkOddNumber(Integer num) {
            return num % 2 == 1;
        }

    }

    public static <E> void Exchange(E[] inputArray, int i, int j) {
        if (i < 0 || j < 0 || i >= inputArray.length || j >= inputArray.length)
            return;
        E tmp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = tmp;
    }

    public static <E extends Comparable> E MaximumValue(List<E> array, int begin, int end) {
        E maxVal = array.get(begin);
        for (; begin < end; begin++) {
            E cur = array.get(begin);
            if (cur.compareTo(maxVal) > 0) {
                maxVal = cur;
            }
        }
        return maxVal;
    }



    public static void main(String[] args) {

        Collection<Integer> ci = Arrays.asList(1, 2, 3, 4);
        System.out.println("number of odd numbers: " + CountIf(ci,  Property::checkOddNumber));

        System.out.println("arrays after exchange 1 and 2");
        Integer[] intArray = { 1, 2, 3, 4, 5 };

        Exchange(intArray, 1, 2);
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

        ArrayList<Integer> al = new ArrayList();

        // add elements to the array list
        al.add(10);
        al.add(4);
        al.add(2);
        al.add(6);
        al.add(2);
        al.add(1);
        System.out.println("max from begin 1 to end 6 is " + MaximumValue(al, 1, al.size()));

    }
}
