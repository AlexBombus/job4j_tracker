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
     * @param profiles список профайлов клиентов
     * @return список адресов без повторяющихся значений
     */
    public List<Address> collectUniqSortedByCity(List<Profile> profiles) {
        return profiles.stream()    // создае поток данных из List<Profile> profiles
                .map(Profile::getAddress) // принимает элемент потока Profile, а возвращает другой эл]. - адрес
                .sorted(Comparator.comparing(Address::getCity)) // сорируе элементы по полю String city.
                .distinct() // осавляе олько уникальные элементы исключая дубликаы
                .collect(Collectors.toList()); // ообранные элеменв собираюся в список List
    }
}
