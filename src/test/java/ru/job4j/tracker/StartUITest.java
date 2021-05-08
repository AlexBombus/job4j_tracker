package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
                )
        );
    }
    
    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Show all Items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Show all items ===" + System.lineSeparator()
                        + "Items list is empty." + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Show all Items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by id ===" + System.lineSeparator()
                        + "No item found with this id." + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdWithItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1", "1", "2"}
        );
        Tracker tracker = new Tracker();
        Item testItem = tracker.add(new Item("test"));
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by id ===" + System.lineSeparator()
                        + testItem + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "test", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindBuNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by name ===" + System.lineSeparator()
                        + "Item with this name was not found." + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameWithItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "test", "1"}
        );
        Tracker tracker = new Tracker();
        Item testItem = tracker.add(new Item("test"));
        UserAction[] actions = {
                new FindBuNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by name ===" + System.lineSeparator()
                        + testItem + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
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
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }
}