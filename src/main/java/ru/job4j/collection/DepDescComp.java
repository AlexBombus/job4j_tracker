package ru.job4j.collection;

import java.util.Comparator;
/**
 *  Class DepDescComp.
 * Класс реализует компаратор для сортировки кодов подразделений по убыванию.
 *
 * @author Aleksandr Elizarov (a.elyzarov@gmail.com)
 * @version 1.0
 * @since  28.05.2021
 *
 */
public class DepDescComp implements Comparator<String> {
    /**
     * Метод переопределяет абстрактный метод compare функционального интерфейса Comparator
     * для сортировки значений кодов подразделений по убыванию.
     *
     * @param o1 входящий код подразделения
     * @param o2 входящий код подразделения
     * С поммощью метода String.split("/") получаем массив одиночных элементов
     * Сравниваем по индексу [0] элементы плученных массивов,
     * тем самым проверяем относимость к одной ветке подведомственности подразделений.
     * Если подразделения относятся к одной ветви проверяем  методом String.compareTo().
     * @return возвращает int = -1, 0 или 1
     */
    @Override
    public int compare(String o1, String o2) {
        String[] dep1 = o1.split("/");
        String[] dep2 = o2.split("/");
         int rsl = dep2[0].compareTo(dep1[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}
