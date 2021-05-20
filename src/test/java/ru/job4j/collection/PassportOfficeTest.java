package ru.job4j.collection;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        MatcherAssert.assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addOnlyOne() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen1 = new Citizen("2f44a", "Petr");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(citizen1));
    }
}