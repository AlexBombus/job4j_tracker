package ru.job4j.poly;

public interface Transport {
    void move();

    void passengers(int pas);

    double fuelExpenses(double litre, double prise);
}
