package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {

    public static void main(String[] args) {
        String[] strings = {"раз", "двойка", "троечка", "четвертый", "пять" };

        Comparator<String> cmpText = (left, right) -> {
            System.out.println("compare - " + right + " : " + left);
            return left.compareTo(right);
        };

        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };

        Arrays.sort(strings, cmpText);
        System.out.println(Arrays.toString(strings));
        System.out.println("_______________________________");
        Arrays.sort(strings, cmpDescSize);
        System.out.println(Arrays.toString(strings));

    }
}
