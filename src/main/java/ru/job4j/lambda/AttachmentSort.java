package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Класс {@AttachmentSort} сортирует объекты по параметрам полям size и name.
 * В классе создаются объекты типа Comparator с использованием анонимных классов
 * которые реализуют интерфейс {@link java.util.Comparator}.
 *
 * @author Aleksandr Elizarov
 * @version 1.0
 */
public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );

        /**
         *Объект типа Comparator создан на основании анонимного класса.
         *Сортирует объекты по возрастанию параметра поля size.
         *Реализует интерфейс {@link java.util.Comparator}
         */
        Comparator<Attachment> sizeComparator = new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(sizeComparator);
        System.out.println(attachments);

        /**
         *Объект типа Comparator создан на основании анонимного класса.
         *Сортирует объекты по возрастанию параметра поля name.
         *Реализует интерфейс {@link java.util.Comparator}
         */
        Comparator<Attachment> nameComparator = new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getName().compareTo(right.getName());
            }
        };
        attachments.sort(nameComparator);
        System.out.println(attachments);

    }
}
