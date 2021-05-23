package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftWord = left.split("\\.");
        String[] rightWord = right.split("\\.");
        int leftLexNum = Integer.parseInt(leftWord[0]);
        int rightLexNum = Integer.parseInt(rightWord[0]);
        return Integer.compare(leftLexNum, rightLexNum);
    }
}
