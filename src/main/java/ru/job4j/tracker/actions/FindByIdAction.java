package ru.job4j.tracker.actions;

import ru.job4j.tracker.entity.Item;
import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

import java.util.Objects;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = store.findById(id);
        out.println(Objects.requireNonNullElse(item, "No item found with this id."));
        return true;
    }
}
