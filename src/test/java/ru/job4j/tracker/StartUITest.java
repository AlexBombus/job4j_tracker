package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByIdAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "Find item by id" + System.lineSeparator()
                        + "=== Find item by id ====" + System.lineSeparator()
                        + "No item found with this id: 1." + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
        ));
    }
}