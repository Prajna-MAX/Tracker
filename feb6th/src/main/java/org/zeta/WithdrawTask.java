package org.zeta;

public class WithdrawTask implements Runnable{
    Account account;
    int amt;

    WithdrawTask(Account account,int amt){
        this.account=account;
        this.amt=amt;

    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        boolean success=account.withdraw(amt);
        if(success){
            System.out.println("successfull");
        }
        else System.out.println("failed");

    }
}
