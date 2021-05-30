package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Класс {@SearchFolder} сортирует объекты folder по параметрам полям size и name.
 * В классе создаются фильтры с определенными условиями фильтрации при создании которых
 * используется функциональный интерфейс Predicate, реализация через лямбда.
 *
 * @author Aleksandr Elizarov
 * @version 1.0
 * @date 01.06.2021
 */
public class SearchFolder {
    /**
     * Фильтры созаны с использованием встроенного функционального интерфейса Predicate
     * для фильтрации объектов по соответствию параметра size заданному условию.
     * Принимают параметр Folder и возвращают boolean значение.
     */
    private Predicate<Folder> filterBySize = folder -> folder.getSize() > 100;
    private Predicate<Folder> filterByName = folder -> folder.getName().contains("bug");

    /**
     * Метод выпорлняет сортировку объектов в списке по заданным параметрав фидльтрации
     * @param list список объектов Folder
     * @param pred вид фильтра по которому будет осуществляться сортировка
     * @return список отсортированных объектов Folder
     */
    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder f : list) {
            if (pred.test(f)) {
                rsl.add(f);
            }
        }
        return rsl;
    }
}

