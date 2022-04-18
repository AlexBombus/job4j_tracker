package ru.job4j.tracker.actions;

import ru.job4j.tracker.entity.Item;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        store.add(item);
        out.println("Item added. " + item);
        return true;
    }
}
