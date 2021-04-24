package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//import static com.sun.tools.javac.util.Constants.format;

public class StartUI {

    public static void main(String[] args) {
        Item par = new Item();
        LocalDateTime currentDateTime = par.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println(currentDateTimeFormat);
    }
}
