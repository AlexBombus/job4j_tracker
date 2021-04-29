package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " -å летит по небу!");
    }

    @Override
    public void passengers(int pas) {
        System.out.println("Вместимость " + pas + " пассажиров.");
    }
}
