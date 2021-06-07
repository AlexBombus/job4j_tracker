package ru.job4j.stream.travelcompany;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    /**
     * Метод формирует список адресов из списка профайлов клиентов,
     * @param profiles список профайлов клиентов
     * @return  список адресов клиентов
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }

    /**
     * Метод формирует список адресов из списка профайлов клиентов,
     * при этом  оставляет только уникальные(неповоряющиеся) элементы.
     * Используются методы Stream API:
     * .stream() создает поток данных из List<Profile> profiles;
     * .map()  принимает элемент потока Profile, а возвращает другой элемент - адрес;
     * .sorted() сортируе элементы по полю String city;
     * .distinct() осавляет только уникальные элементы исключая дубликаты;
     * .collect() отобранные элементы собираются в список List
     * @param profiles список профайлов клиентов
     * @return список адресов без повторяющихся значений
     */
    public List<Address> collectUniqSortedByCity(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}
