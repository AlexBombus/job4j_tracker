package ru.job4j.function;

import java.util.*;
import java.util.function.*;

/**
 * Класс {@FunctionalInterfaces} создан для отработки практики применения
 * встроенных функциональных интерфейсов
 *
 *  @author Aleksandr Elizarov
 *  @version 1.0
 *  @date 30.05.2021
 */
public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");

        /*
          Consumer и BiConsumer используются если нужно применить действие или операцию к параметру
          (для BiConsumer два параметра)
         */
        BiConsumer<Integer, String> biCon = (num, str) -> map.put(num, str);
        int n = 1;
        for (String s : list) {
            biCon.accept(n++, s);
        }

        /*
          Predicate и BiPredicate - наиболее часто применяется в фильтрах и сравнении
         */
        BiPredicate<Integer, String> biPred = (num, str) -> (num % 2 == 0 || str.length() == 4);
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        /*
         Supplier (поставщик) используется для создания какого-либо объекта
          и при этом ему не требуется входной параметр.
         */
        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        Consumer<String> con = (str) -> System.out.println(str);
        for (String s : sup.get()) {
            con.accept(s);
        }

        /*
          Function используется для преобразования входного параметра в какое-либо значение,
           тип возвращаемого значения может не совпадать с типом входных параметров.
           Bли двух параметров (для Bi-формы этого функционального интерфейса).
         */
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : sup.get()) {
            System.out.println(func.apply(s));
        }
    }
}
