package org.zeta;

public class DepositTask implements Runnable{
    Account account;
    int amt;

    DepositTask(Account account,int amt){
        this.account=account;
        this.amt=amt;

    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        account.deposit(amt);

            System.out.println("depositTask : successfull");


    }
}
