package org.zeta;

public class Account {
    public Double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    Double balance;
    private int id;
    Account(double balance) {
        this.balance = balance;

    }
}
