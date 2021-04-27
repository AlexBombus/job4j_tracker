package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll(Item[] items) {
        Item[] itemsWithoutNull = new Item[this.size];
        int itemsWithoutNullSize = 0;
        for (Item item : items) {
            if (item.getName() != null) {
                itemsWithoutNull[itemsWithoutNullSize] = item;
                itemsWithoutNullSize++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, itemsWithoutNullSize);
    }

    public Item[] findByName(String key) {
        Item[] itemsWithName = new Item[this.size];
        int itemsWithNameSize = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsWithName[itemsWithNameSize] = item;
                itemsWithNameSize++;
            }
        }
        return Arrays.copyOf(itemsWithName, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        if (findById(id) != null) {
            item.setId(id);
            items[indexOf(id)] = item;
            return true;
        } else {
            return false;
        }
    }
}

