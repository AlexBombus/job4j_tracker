package ru.job4j.poly;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - едет по автомобильной дороге!");
    }

    @Override
    public void passengers(int pas) {
        System.out.println("Вместимость " + pas + " пассажиров.");
    }
}
