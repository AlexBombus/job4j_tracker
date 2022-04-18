package ru.job4j.tracker.actions;

import ru.job4j.tracker.entity.Item;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Edit item ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (store.replace(id, item)) {
            out.println("Item has been edited successfully.");
        } else {
            out.println("Error. Item with this id was not found.");
        }
        return true;
    }
}
