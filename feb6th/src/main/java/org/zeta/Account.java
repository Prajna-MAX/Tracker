package org.zeta;

public class Account {
    private int bal;

    Account(int bal){
        this.bal=bal;
    }

    synchronized public int getBal() {
        return bal;
    }
    synchronized boolean withdraw(int amount){
        try {
            if (bal < amount) {
                throw new Exception("Insufficient Balance");
            }
            bal -= amount;
            return true;
        }
         catch (Exception e) {
            return false;
        }
    }
    synchronized void deposit(int amount){
        bal+=amount;
    }
}
