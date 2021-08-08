package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SqlTrackerTest {

    static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

//    @Ignore
//    public void whenFindById() {
//        SqlTracker tracker = new SqlTracker(connection);
//        Item item = new Item("item");
//        int id = tracker.add(item).getId();
//        Assert.assertEquals(tracker.findById(id), item);
//    }
//
//    @Ignore
//    public void whenReplaceItem() {
//        SqlTracker tracker = new SqlTracker(connection);
//        Item item1 = new Item("item1");
//        Item item2 = new Item("item2");
//        int id = tracker.add(item1).getId();
//        tracker.replace(id, item2);
//        Assert.assertEquals(tracker.findById(id), item2);
//    }
//
//    @Ignore
//    public void whenFindAll() {
//        SqlTracker tracker = new SqlTracker(connection);
//        Item item1 = new Item("item1");
//        Item item2 = new Item("item2");
//        Item item3  = new Item("item3");
//        tracker.add(item1);
//        tracker.add(item2);
//        tracker.add(item3);
//        List<Item> exp = Arrays.asList(item1, item2, item3);
//        Assert.assertEquals(tracker.findAll(), exp);
//    }
//
//    @Ignore
//    public void whenFindByName() {
//        SqlTracker tracker = new SqlTracker(connection);
//        Item item1 = new Item("item");
//        Item item2 = new Item("item");
//        Item item3 = new Item("not");
//        tracker.add(item1);
//        tracker.add(item2);
//        tracker.add(item3);
//        List<Item> exp = Arrays.asList(item1, item2);
//        Assert.assertEquals(tracker.findByName("item"), exp);
//    }
//
//    @Ignore
//    public void whenDeleteItem() {
//        SqlTracker tracker = new SqlTracker(connection);
//        Item item1 = new Item("item1");
//        Item item2 = new Item("item2");
//        Item item3  = new Item("item3");
//        tracker.add(item1);
//        tracker.add(item2);
//        tracker.add(item3);
//        tracker.delete(item3.getId());
//        List<Item> exp = Arrays.asList(item1, item2);
//        Assert.assertEquals(tracker.findAll(), exp);
//    }
}