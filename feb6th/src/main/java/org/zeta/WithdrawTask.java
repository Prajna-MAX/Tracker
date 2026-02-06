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
        try {
            account.withdraw(amt);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
