package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс создан для решения задачи:
 * В школе пришло требование разделить 9А класс на три класса.
 * У каждого ученика есть общий балл по всем предметам.  int score;
 * score - может быть в диапазоне от 0 до 100.
 * Учеников нужно поделить на следующие группы.
 * 10А диапазон балла [70: 100],
 * 10Б диапазон балла [50: 70);
 * 10B диапазон балла (0: 50);
 */
public class School {

    /*
    для решения задачи можно использовать предикаты:
    private Predicate<Student> sort10A = student -> student.getScore() >= 70;
    private Predicate<Student> sort10B
            = student -> student.getScore() >= 50 && student.getScore() < 70;
    private Predicate<Student> sort10V = student -> student.getScore() < 50;

     */

    /**
     * Метод осуществляет фильтрацию учеников по заданному предикату
     * @param students входящий список всех студентов
     * @param predict предикат с заданным условием отбора
     * @return возвращаемый список отобранных студентов
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    /**
     * Метод преобразовывает список учеников в Мар.
     * Для преобразования в Мар используется collect c аргументом Collectors.toMap.
     * @param students взодящий список учеников
     * @return Мар в которой качестве ключа используется фамилию ученика, значение - объект ученика.
     */
    public Map<String, Student> listToMap(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                student -> student
                        ));
    }
}
