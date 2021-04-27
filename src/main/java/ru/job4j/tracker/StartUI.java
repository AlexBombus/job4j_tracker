package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item par = new Item();
        tracker.add(par);
        System.out.println(tracker.findById(par.getId()));

        /* Время создания заявки
        LocalDateTime currentDateTime = par.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println(currentDateTimeFormat);

         */

    }
}
