package org.zeta;

public class SavingAccount implements Account{
    private int balance;
    SavingAccount(int amt){
        balance=amt;
    }

    public int getBalance(){
        return balance;
    }

    void validate(int amt){
        if(amt>balance){
            throw new IllegalArgumentException("NEGATIVE VALUE");
        }

}

    @Override
    public void withdraw(int amt) {
        try {
            validate(amt);
            balance -= amt;
        }

        catch(InsuffiecientBankBalance insuffiecientBankBalance){
            throw new InsuffiecientBankBalance("low balance");
        }
    }

    @Override
    public void deposit(int amt) {
        balance+=amt;

    }
}
