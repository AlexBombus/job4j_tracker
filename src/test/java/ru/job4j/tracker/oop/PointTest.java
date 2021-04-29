package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenAX1Y5BX1Y3Then0() {
        Point a = new Point(1, 5);
        Point b = new Point(1, 3);
        double actual = a.distance(b);
        double expect = 2.0;
        Assert.assertEquals(expect, actual, 0.1);
    }

    @Test
    public void whenAX1Y1Z1BX1Y1Z4Then3() {
        Point a = new Point(1, 3, 1);
        Point b = new Point(1, 3, 4);
        double actual = a.distance3d(b);
        double expect = 3.0;
        Assert.assertEquals(expect, actual, 0.1);
    }
}