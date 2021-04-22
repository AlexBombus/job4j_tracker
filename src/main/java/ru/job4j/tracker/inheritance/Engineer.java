package ru.job4j.tracker.inheritance;

public class Engineer extends Profession {
    private int projects;

    public Engineer(String name, String surname, String education, String birthday, int projects) {
        super(name, surname, education, birthday);
        this.projects = projects;
    }

    public void toDo() {
    }
}
