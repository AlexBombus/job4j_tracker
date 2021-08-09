package ru.job4j.inheritance;

public class Builder extends Engineer {
    private String kindOfInstrument;

    public Builder(String name, String surname, String education,
                   String birthday, int projects, String kindOfInstrument) {
        super(name, surname, education, birthday, projects);
        this.kindOfInstrument = kindOfInstrument;
    }

    public void whatBuild() {

    }
}
