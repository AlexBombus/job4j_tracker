package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    private Predicate<Student> sort10A = student -> student.getScore() >= 70;
    private Predicate<Student> sort10B
            = student -> student.getScore() >= 50 && student.getScore() < 70;
    private Predicate<Student> sort10V = student -> student.getScore() < 50;

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}
