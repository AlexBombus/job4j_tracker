package ru.job4j.tracker.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student alex = new Student();
        alex.setName("Alex");
        alex.setGroup("59/a");
        alex.setEntered(LocalDate.of(2020, 9, 1));
        System.out.println("Студент " + alex.getName() + " поступил " + alex.getEntered()
                            + " учится в группе " + alex.getGroup());

    }
}
