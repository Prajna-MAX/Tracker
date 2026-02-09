package org.zeta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface addAccount {
    boolean checkAcc(int id);
}

public class Bank {
    double interest;

    Bank(double interest) {
        this.interest = interest;
    }

    static List<LoanAccount> accounts = new ArrayList<>();

    static Consumer<LoanAccount> addAccount =
            account -> accounts.add(account);


    static Predicate<Integer> accountExists= (accountId) -> {
        for (LoanAccount acc : accounts) {
            if (acc.getId() == accountId) return true;

        }
        return false;


    };

    static Predicate<LoanAccount> checkBal = account-> account.getBal() >= 1000;


}
