package ru.job4j.tracker.comparators;

import ru.job4j.tracker.entity.Item;

import java.util.Comparator;

public class SortDownByIdItems implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return Integer.compare(item2.getId(), item1.getId());
    }
}
