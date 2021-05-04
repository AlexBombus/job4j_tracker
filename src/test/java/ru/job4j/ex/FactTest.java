package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test
    public void whenN3() {
        Fact fact = new Fact();
        assertEquals(6, fact.calc(3));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNLess0() {
        Fact fact = new Fact();
        fact.calc(-2);
    }
}