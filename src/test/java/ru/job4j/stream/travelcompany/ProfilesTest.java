package ru.job4j.stream.travelcompany;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProfilesTest {

    @Test
    public void whenCollectSuccessful() {
        Profiles pro = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Москва", "Кремль", 5, 2)),
                new Profile(new Address("Питер", "Невский", 10, 3)),
                new Profile(new Address("Хабаровск", "Сосновая", 1, 7)),
                new Profile(new Address("Тверь", "Горького", 4, 6))
        );
        List<Address> expected = List.of(
                new Address("Москва", "Кремль", 5, 2),
                new Address("Питер", "Невский", 10, 3),
                new Address("Хабаровск", "Сосновая", 1, 7),
                new Address("Тверь", "Горького", 4, 6)
        );
        List<Address> rsl = pro.collect(profiles);
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenCollectFalse() {
        Profiles pro = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Москва", "Кремль", 5, 2)),
                new Profile(new Address("Питер", "Невский", 10, 3)),
                new Profile(new Address("Хабаровск", "Сосновая", 1, 7)),
                new Profile(new Address("Тверь", "Горького", 4, 6))
        );
        List<Address> expected = List.of(
                new Address("Москва", null, 5, 2),
                new Address("Питер", "Невский", 0, 3),
                new Address("Хабаровск", "Сосновая", 0, 7),
                new Address("Тверь", "Горького", 4, 6)
        );
        List<Address> rsl = pro.collect(profiles);
        Assert.assertNotEquals(rsl, expected);
    }

    @Test
    public void whenCollectUniqSortedByCity() {
        Profiles pro = new Profiles();
        List<Profile> profiles = List.of(
                new Profile(new Address("Питер", "Невский", 10, 3)),
                new Profile(new Address("Питер", "Невский", 10, 3)),
                new Profile(new Address("Хабаровск", "Сосновая", 1, 7)),
                new Profile(new Address("Тверь", "Горького", 4, 6))
        );
        List<Address> expected = List.of(
                new Address("Питер", "Невский", 10, 3),
                new Address("Тверь", "Горького", 4, 6),
                new Address("Хабаровск", "Сосновая", 1, 7)
        );
        List<Address> rsl = pro.collectUniqSortedByCity(profiles);
        Assert.assertEquals(rsl, expected);
    }
}