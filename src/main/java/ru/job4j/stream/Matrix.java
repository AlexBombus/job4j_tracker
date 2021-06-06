package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс создан для выполнения задания по преобразованию двумерного массива в список.
 */
public class Matrix {
    /**
     * Метод преобразует матрицу Integer[][] в список чисел.
     * При решении задачи использовались методы flatMap(), collect(), Stream.of().
     *
     * @param numbers входящий параметр двумерный массив Integer[][].
     * @return выходящий список чисел.
     */
    public List<Integer> convert(Integer[][] numbers) {
        return Arrays.stream(numbers)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList()
                );
    }
}
