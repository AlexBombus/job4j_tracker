package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("asv@asd.ru", "Ivan Ivanov");
        hashMap.put("bsd@asd.ru", "Iv Ivanov");
        hashMap.put("vse@asd.ru", "Ivan Ivo");
        hashMap.put("gs@asd.ru", "In Iva");
        hashMap.put("dd@asd.ru", "Van Nov");
        for (String key : hashMap.keySet()) {
            System.out.println(key + " - " + hashMap.get(key));
        }
    }
}
