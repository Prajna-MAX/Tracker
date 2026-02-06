package org.zeta;

public class DepositTask implements Runnable{
    LoanAccount account;
    int amt;

    DepositTask(LoanAccount account, int amt){
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
