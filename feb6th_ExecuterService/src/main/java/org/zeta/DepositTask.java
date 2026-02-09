package org.zeta;

public class DepositTask {
    private int amt;
    DepositTask(int amt){
        this.amt=amt;
    }
    public int call() throws Exception{
        String thread= Thread.currentThread.getName();
        System.out.println(thread+"depositing"+amt);
        bank.deposit(amt);
        System.out.println(thread+"depositing"+amt);
        return bank.getBalance();
    }
}
