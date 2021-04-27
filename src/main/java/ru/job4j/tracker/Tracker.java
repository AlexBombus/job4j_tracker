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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsWithName = new Item[this.size];
        int count = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsWithName[count] = item;
                count++;
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
        int i = indexOf(id);
        if (i != -1) {
            item.setId(id);
            items[i] = item;
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int i = indexOf(id);
        System.arraycopy(items, i + 1, items, i, items.length - 1 - i);
        items[items.length - 1] = null;
        size--;
        return true;
    }
}

