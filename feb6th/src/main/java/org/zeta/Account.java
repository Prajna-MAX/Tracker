package org.zeta;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int bal;
    private int id;
    private final List<String> transactions = new ArrayList<>();

    public Account(int id, int bal) {
        this.id = id;
        this.bal = bal;
    }

    public synchronized int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    public int getId() {
        return id;
    }

    synchronized boolean withdraw(int amount) {
        if (amount <= 0) return false;

        if (bal < amount) {
            return false;
        }

        bal -= amount;
        TransactionInfo t1= new TransactionInfo("DEBIT", amount);
        transactions.add(String.valueOf(t1));
        System.out.println(transactions);
        return true;
    }

    synchronized void deposit(int amount) {
        bal += amount;
        TransactionInfo t1= new TransactionInfo("CREDIT", amount);
        transactions.add(String.valueOf(t1));
        System.out.println(transactions);
    }


    public void addTransaction(String t) {
        transactions.add(t);
    }

    public List<String> getTransactions() {
        return transactions;
    }

}
