package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private int ownTeeth;

    public Dentist(String name, String surname, String education,
                   String birthday, int experience, int ownTeeth) {
        super(name, surname, education, birthday, experience);
        this.ownTeeth = ownTeeth;
    }

    public void drills() {

    }
}
