package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Используем Stream API  совместно с лямбда-выражением для фильтрации списка чисел.
 * С помощью stream()  создаем поток данных списка, метод filter() сортирует потока так,
 * чтобы в нем остались только положительные числа.Условия сортировки задается лямбда.
 * Метод collect(Collectors.toList()) позволяет полученный результат сохранить в коллекции типа List
 */
public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 2, -5, 10, -78, 0);
        List<Integer> sorted = numbers.stream().filter(num -> num > 0).collect(Collectors.toList());
        System.out.println(sorted);
    }
}
