package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Едем в далекие края!");
    }

    @Override
    public void passengers(int pas) {
        System.out.println("Везем " + pas + " пассажиров.");
    }

    @Override
    public double fuelExpenses(double litre, double prise) {
        return litre * prise;
    }
}
