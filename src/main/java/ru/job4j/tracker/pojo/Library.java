package ru.job4j.tracker.pojo;

public class Library {
    public static void main(String[] args) {
        Book cheb = new Book("Чебурашка", 50);
        Book ball = new Book("Колобок", 15);
        Book moydodyr = new Book("Мойдодыр", 10);
        Book cleanCode = new Book("Clean code", 1150);
        Book[] lib = new Book[] {cheb, ball, moydodyr, cleanCode};

        for (Book book: lib) {
            System.out.println("Книга " + book.getName() + ", " + book.getPages() + " страниц.");
        }
        System.out.println();
        Book n = lib[3];
        lib[3] = lib[0];
        lib[0] = n;
        for (Book book: lib) {
            System.out.println("Книга " + book.getName() + ", " + book.getPages() + " страниц.");
        }
        System.out.println();
        for (int i = 0; i < lib.length; i++) {
            if (lib[i].getName().equals("Clean code")) {
                System.out.println("Книга " + lib[i].getName() + ", " + lib[i].getPages() + " страниц.");
            }
        }

    }
}
