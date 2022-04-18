package ru.job4j.tracker.actions;

import ru.job4j.tracker.io.Input;
import ru.job4j.tracker.io.Output;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Exit Program ===");
        return false;
    }
}

