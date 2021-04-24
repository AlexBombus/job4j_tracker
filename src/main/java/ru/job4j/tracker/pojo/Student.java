package ru.job4j.tracker.pojo;

import java.time.LocalDate;

public class Student {
    private String name;
    private String group;
    private LocalDate entered;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getEntered() {
        return entered;
    }

    public void setEntered(LocalDate entered) {
        this.entered = entered;
    }
}
