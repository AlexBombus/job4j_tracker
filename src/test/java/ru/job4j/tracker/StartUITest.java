package ru.job4j.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    /**
     *  public static void createItem(Input input, Tracker tracker) {
     *         System.out.println("=== Create a new Item ====");
     *         String name = input.askStr("Enter name: ");
     *         Item item = new Item(name);
     *         tracker.add(item);
     *         System.out.println("Item added: " + item + ".");
     *     }
     */
//    @Test
//    public void whenAddItem() {
//        String[] answers = {"Fix PC"};
//        Input input = new StubInput(answers);
//        Tracker tracker = new Tracker();
//        StartUI.createItem(input, tracker);
//        Item created = tracker.findAll()[0];
//        Item expected = new Item("Fix PC");
//        MatcherAssert.assertThat(created.getName(), is(expected.getName()));
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("new item");
//        tracker.add(item);
//        String[] answers = {
//                String.valueOf(item.getId()), /* id сохраненной заявки в объект tracker. */
//                "replaced item"
//        };
//        StartUI.editItem(new StubInput(answers), tracker);
//        Item replaced = tracker.findById(item.getId());
//        MatcherAssert.assertThat(replaced.getName(), is("replaced item"));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Tracker tracker = new Tracker(); //Создаем объект tracker
//        Item item = new Item("new item"); // Создаем объект item
//        tracker.add(item); // Добавляем item в tracker
//        String[] answers = {String.valueOf(item.getId())}; // создаем массив с ответом в виде id
//        StartUI.deleteItem(new StubInput(answers), tracker); //вызываем тестируемый метод deleteItem
//        assertNull(tracker.findById(item.getId())); // сравниваем с null результат поиска по id
//    }
}