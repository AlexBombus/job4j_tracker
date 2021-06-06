package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс задает методы по вводу в базу данных (БД) новых пользователей (клиентов Банка),
 * поиску данных и осуществлению транзакций между счетами пользователей.
 * переменная users типа HashMap выступает в роли БД принимает и хранит  данные
 * о клиентах банка и списки их счетов в виде коллекции List<Account>
 *
 *  @author Aleksandr Elizarov
 *  @version 1.0
 */

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод  добавляет в БД данные о клиенте, ничего не возвращае.
     * Метод  Map.putIfAbsent осуществляет проверку на наличие такого клиента в БД,
     * добавляет его в случае, если такого там еще нет и создает пустой массив списка счетов
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет данные счета пользователя.
     * В текущей редакции метода использование цикла заменено на Stream API
     * @param passport номер паспорта клиента
     * @param account  содержит реквизиты и баланс счета клиента
     * Используется метод findByPassport  для поиска клиента по номеру паспорта
     * В методе осуществляется проверка клента на null и на дублирование счета в БД
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }

        }
    }

    /**
     * Метод осуществляет поиск клиента по номеру паспорта
     * В текущей редакции метода использование цикла заменено на Stream API
     * @param passport - номер паспорта клиента
     * @return данные о клиенте в виде {@link User } если таковой найден в БД
     * или  null - если не найден.
     */
    public User findByPassport(String passport) {
                return users.keySet().stream()
                        .filter(user -> user.getPassport().equals(passport))
                        .findFirst()
                        .orElse(null);
            }
    /*
    Предыдущая реализация метода findByPassport():
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }
     */

    /**
     * Метод находит счет  клиента по реквизитам
     * @param passport - паспортные данные клента
     * @param requisite - реквизиты счета
     * @return счет клента если такой найден в БД и null -если не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
        return users.get(user).stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst()
                .orElse(null);
        }
        return null;
    }
    /*
    Предыдущая реализация метода findByRequisite():
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
                for (Account account : list) {
                    if (account.getRequisite().equals(requisite)) {
                        return account;
                    }
                }
        }
        return null;
    }
     */

    /**
     * Метод выполняет р анзакции ежду счетами клиентов
     * @param srcPassport - данные владельца счета списания средств
     * @param srcRequisite - рекквизиты счета спиания средств
     * @param destPassport - данные владельца счета зачисления средств
     * @param destRequisite - рекквизиты счета зачисления средств
     * @param amount - размер средств транзакции
     * @return - true в случае успешной транзакции, false -  в случае отказа
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            return true;
        }
        return false;
    }
}
