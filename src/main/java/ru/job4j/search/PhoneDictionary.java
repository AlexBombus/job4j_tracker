package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Класс формирует список абонентов.
 * Содержит метод по добавлению абонента в список абонентов
 * и метод поиска абонента  в списке по ключу.
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     *Метод фильтрует список абонентов по содержанию key в переменной объекта.
     * Метод поиска фильтрует все поля объекта Person.
     * Реализацию метода переписали с использованием функции высшего порядка.
     * с применением функционального интерфейса java.util.function.Predicate и лямбда.
     *
     * @param key значение по содержанию которого осуществляем фильтрацию
     * @return список абонентов содержащих key в переменной.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> combine =(person) -> (
                person.getName().contains(key)
                        || person.getSurname().contains(key)
                        || person.getPhone().contains(key)
                        || person.getAddress().contains(key)
        );
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
 /*
 Предыдущая реализация метода:
 public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getPhone().contains(key)
                    || person.getAddress().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
  */