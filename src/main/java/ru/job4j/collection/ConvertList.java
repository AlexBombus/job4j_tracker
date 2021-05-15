package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    /**
     * Метод преобразует список с массивом чисел в список чисел.
     */
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] integers : list) {
            for (int num : integers) {
                rsl.add(num);
            }
        }
        return rsl;
    }
}
