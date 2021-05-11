package ru.job4j.tracker;

/**
 * Реализация шаблона проектирования Singleton
 * Шаблон singleton - используется для создания класса, который может содержать только один
 * экземпляр объекта этого класса.
 *
 * 1)Создаем  public final class - чтобы его нельзя было наследовать.
 * 2) сделаем статическое поле для хранения экземпляра класса
 * и по умолчанию оставляем пустым - private static SingleTracker instance = null;
 * 3) создаем пустой  конструктор класса, с модификатором доступа private,
 * чтобы никто больше не мог создать  объекто класса;
 * 4) добавляем public static метод, чтобы другие классы могли получить доступ к объекту при этом
 * делаем так, чтобы экземпляр создавался по первому вызову этого метода - getInstance()
 *
 *Так как нам нужно чтобы класс мог реализовывать все методы от класса Tracker,
 * воспользовались композицией объектов чтобы не копировать код из класса трекер.
 *
 */

public final class SingleTracker {

    private static SingleTracker instance = null;

    private Tracker tracker = new Tracker();

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item[] findAll() {
        return tracker.findAll();
    }

    public Item[] findByName(String key) {
        return tracker.findByName(key);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return tracker.delete(id);
    }
}

