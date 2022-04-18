package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.comparators.SortDownByNameItems;
import ru.job4j.tracker.entity.Item;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
public class SortDownByNameItemsTest {

    @Test
    public void compare() {
        Item item1 = new Item("Petya");
        Item item2 = new Item("Olya");
        Item item3 = new Item("Vasya");
        List<Item> input = Arrays.asList(item1, item2, item3);
        input.sort(new SortDownByNameItems());
        assertEquals(input.get(0).getName(), "Vasya");
        assertEquals(input.get(1).getName(), "Petya");
        assertEquals(input.get(2).getName(), "Olya");
    }
}