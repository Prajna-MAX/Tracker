package org.zeta;

public class WithdrawTask implements Runnable{
    LoanAccount account;
    int amt;

    WithdrawTask(LoanAccount account, int amt){
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
