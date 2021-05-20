package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!this.users.containsKey(user)) {
            this.users.put(user, new ArrayList<Account>());
        } else {
            System.out.println("Error. User with this passport data is already in the system.");
        }

    }

    public void addAccount(String passport, Account account) {
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.users.get(user).add(account);
                break;
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> list = users.get(findByPassport(passport));
        if (list != null) {
            for (Account account : list) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && amount > 0 && amount <= src.getBalance() && dest != null) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            return true;
        }
        return false;
    }
}
