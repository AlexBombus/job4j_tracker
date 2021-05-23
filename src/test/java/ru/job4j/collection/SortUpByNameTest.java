package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortUpByNameTest {

    @Test
    public void compare() {
        List<Job> input = Arrays.asList(
                new Job("Make bug", 1),
                new Job("Fix bug", 4),
                new Job("X task", 2),
                new Job("Fix bug", 3)
        );
        input.sort(new SortUpByName());
        assertEquals(input.get(0).getName(), "Fix bug");
        assertEquals(input.get(1).getName(), "Fix bug");
        assertEquals(input.get(2).getName(), "Make bug");
        assertEquals(input.get(3).getName(), "X task");
    }

    @Test
    public void whenSortUpByNameAndDownByPriority() {
        List<Job> input = Arrays.asList(
                new Job("Make bug", 1),
                new Job("Fix bug", 4),
                new Job("X task", 2),
                new Job("Fix bug", 3)
        );
        input.sort(new SortUpByName().thenComparing(new SortDownByPriority()));
        assertEquals(input.get(0).getName(), "Fix bug");
        assertEquals(input.get(0).getPriority(), 4);
        assertEquals(input.get(1).getName(), "Fix bug");
        assertEquals(input.get(1).getPriority(), 3);
    }
}