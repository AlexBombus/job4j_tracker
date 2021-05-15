package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {

        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        List<Item> items = tracker.findAll();
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
