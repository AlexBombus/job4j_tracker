package ru.job4j.tracker;

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
    public boolean execute(Input input, MemTracker memTracker) {
        out.println("=== Show all items ===");
        List<Item> items = memTracker.findAll();
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
