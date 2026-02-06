package org.zeta;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    double interest;
    Bank(double interest){
        this.interest=interest;
    }
    static List<LoanAccount> accounts=new ArrayList<>();

    void addAccount(LoanAccount account){
        accounts.add(account);
    }

    static boolean checkAcc(int accountId){
        for(LoanAccount acc:accounts){
            if(acc.getId()==accountId)return true;

        }
        return false;


    }
    static boolean checkBal(LoanAccount account){
        return account.getBal() >= 1000;
    }

}
