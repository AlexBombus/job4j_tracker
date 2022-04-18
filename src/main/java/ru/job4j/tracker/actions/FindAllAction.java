package ru.job4j.tracker.actions;

import ru.job4j.tracker.entity.Item;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {

        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Show all items ===");
        List<Item> items = store.findAll();
        if (items.isEmpty()) {
            out.println("Items list is empty.");
        } else {
            for (Item item : items) {
                out.println(item + ";");
            }
        }
        return true;
    }
}
