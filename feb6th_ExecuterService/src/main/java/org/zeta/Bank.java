package org.zeta;

public class Bank {

    Bank(int amt){
        this.amt=amt;
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

}