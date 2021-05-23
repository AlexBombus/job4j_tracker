package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortDownByNameTest {

    @Test
    public void compare() {
        List<Job> input = Arrays.asList(
                new Job("Make bug", 1),
                new Job("Fix bug", 4),
                new Job("X task", 2),
                new Job("Fix bug", 3)
        );
        input.sort(new SortDownByName());
        assertEquals(input.get(0).getName(), "X task");
        assertEquals(input.get(1).getName(), "Make bug");
        assertEquals(input.get(2).getName(), "Fix bug");
        assertEquals(input.get(3).getName(), "Fix bug");
    }
}