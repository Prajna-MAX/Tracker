package org.zeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;



public class Bank {
    double interest;

    Bank(double interest) {
        this.interest = interest;
    }

    static Map<Integer,Account> accounts = new HashMap<>();

    static Consumer<Account> addAccount =
            account -> accounts.put(account.getId(),account);

    Account account = new Account(123, 1000);



    static Predicate<Integer> accountExists = (accountId) -> accounts.containsKey(accountId);


    static Predicate<Account> checkBal = account -> account.getBal() >= 1000;


}
