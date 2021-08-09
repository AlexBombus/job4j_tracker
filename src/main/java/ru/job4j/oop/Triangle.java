package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) { // конструктор
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * метод вычисляет возвращаем полупериметр треугольникака
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    /**
     * метод проверяет возможность сущствования треугольника с заданными длинами сторон
     *
     */
    public boolean exist(double ab, double ac, double bc) { //
        return ab + ac > bc && ab + bc > ac && bc + ac > ab;
    }

    /**
     * Метод высчитывает площадь треугольника
     */
    public double area() {
        double rsl = 0;
        double ab = first.distance(second); // расстояние между а и b
        double ac = first.distance(third);  // расстояние между а и c
        double bc = second.distance(third);  // расстояние между b и c
        double p = period(ab, ac, bc);   // полупериметр
        if (this.exist(ab, ac, bc)) {   // проверка на возможность треугольника
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc)); // формула площади треугольника
        }
        return rsl;
    }
}
