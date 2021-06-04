package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс  создан для практики упрощения написания лямбда
 */
public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
/*
 Требовалось упростить данное написание лямбда
 Изначальный код -  Consumer<String> out = (name) -> cutOut(name);
 */
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    /**
     * Метод выводит в консоль имя и если оно больше 10 символов, то вывод обрезается.
     * @param value - имя из списка names;
     */
    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10) + "..");
        } else {
            System.out.println(value);
        }
    }
}
