package ru.job4j.tracker.inheritance;

public class Surgeon extends Doctor {
    private String grade;

    public Surgeon(String name, String surname, String education,
                   String birthday, int experience, String grade) {
        super(name, surname, education, birthday, experience);
        this.grade = grade;
    }

    public void heal() {
    }
}
