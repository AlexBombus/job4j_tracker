package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        StringBuilder leftNum = new StringBuilder();
        for (int i = 0; i < left.length(); i++) {
            if (Character.isDigit(left.charAt(i))) {
                leftNum.append(left.charAt(i));
            } else {
                break;
            }
        }
        StringBuilder rightNum = new StringBuilder();
        for (int i = 0; i < right.length(); i++) {
            if (Character.isDigit(right.charAt(i))) {
                rightNum.append(right.charAt(i));
            } else {
                break;
            }
        }
        int leftLexNum = Integer.parseInt(leftNum.toString());
        int rightLexNum = Integer.parseInt(rightNum.toString());
        return Integer.compare(leftLexNum, rightLexNum);
    }
}
