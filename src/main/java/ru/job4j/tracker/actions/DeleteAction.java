package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Delete Item ===");
        int id = input.askInt("Enter id: ");
        if (store.delete(id)) {
            out.println("The item has been successfully deleted.");
        } else {
            out.println("Error. No item found with this id.");
        }
        return true;
    }

}
