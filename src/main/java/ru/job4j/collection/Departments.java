package ru.job4j.collection;

import java.util.*;

/**
 *  Class Departments.
 * Класс создает список всех подразделений,
 * а также производит сортировку кодов подразделений.
 *
 * @author Aleksandr Elizarov (a.elyzarov@gmail.com)
 * @version 1.0
 * @since  28.05.2021
 */
public class Departments {

    /**
     * Метод добавляет пропущенные коды подразделения и возвращает их полный список.
     * @param deps - принимает перечень подразделений.
     * @return - возвращает неупорядоченный список с перечнем всех подразделений.
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String[] val = value.split("/");
            String start = val[0];
            tmp.add(start);
            for (int i = 1; i < val.length; i++) {
                tmp.add(start + "/" + val[i]);
                start += "/" + val[i];

            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Метод осуществляет сортировку по возрастанию, ничего не возвращает.
     * @param orgs входящий список кодов подразделений
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    /**
     * Метод осуществляет сортировку по убыванию, ничего не возвращает.
     * Использует компаратор переопределенный в классе {@link DepDescComp}.
     * @param orgs входящий список кодов подразделений
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}