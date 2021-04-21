package ru.job4j.tracker.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo(Error error) {
        System.out.println("Подключение: " + this.active);
        System.out.println("Код ошибки: " + this.status);
        System.out.println("Сообщение: " + this.message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 666, "All system are destroyed");
        error.printInfo(error);
    }
}
