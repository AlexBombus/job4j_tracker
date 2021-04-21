package ru.job4j.tracker.oop;

public class Battery {

    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        int sumLoad = this.load + another.load;
        System.out.println("Общий заряд батареек: " + sumLoad);
    }

    public static void main(String[] args) {
        Battery bat1 = new Battery(5);
        Battery bat2 = new Battery(10);
        bat1.exchange(bat2);
    }
}
