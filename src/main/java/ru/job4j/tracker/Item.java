package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        LocalDateTime currentDateTime = this.created;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        return "Item{" + "id = " + id + ", name = '" + name + '\''
                + ", created = " + currentDateTimeFormat + '}';
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
    /** Изменение формата времени создания заявки
    LocalDateTime currentDateTime = par.getCreated();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String currentDateTimeFormat = currentDateTime.format(formatter);
    System.out.println(currentDateTimeFormat);
    */