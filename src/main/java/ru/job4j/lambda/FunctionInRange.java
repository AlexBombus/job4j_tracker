package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Класс реализует подсчет функции в  диапазоне чисел с использованием
 * встроенных функциональных интерфейсов и лямда.
 */
public class FunctionInRange {
    /**
     *Метод реализует подсчет значений заданной функции в определенном диапазоне чисел.
     * Примеры реализации зазличных функций находятся в тесте на данный метод.
     * @param start начало диапазона.
     * @param end конец диапазона.
     * @param function  заданная функция расчета (молжет быть линейной, квадратичной и тд).
     * @return список значений результатов расчета функции.
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> function) {
/*
При использовании идентификатора var - компилятор проверяет правую часть от оператора присваивания,
определяет конкретный тип переменной и заменяет им var, что позволяет сократить шаблон кода.
*/
        var rsl = new ArrayList<Double>();
        for (int i = start; i <= end; i++) {
            rsl.add(function.apply(i * 1.0));
        }
        return rsl;
    }
}
