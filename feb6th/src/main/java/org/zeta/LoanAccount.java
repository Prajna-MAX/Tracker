package org.zeta;

public class LoanAccount {
    private int bal;
    private int id;

    public int getId() {
        return id;
    }

    LoanAccount(int id, int bal){
        this.id=id;
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
