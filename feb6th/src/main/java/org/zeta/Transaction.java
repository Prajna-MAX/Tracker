package org.zeta;

public class Transaction {
    final Account account1,account2;

Transaction(Account a1,Account a2){
    account1=a1;
    account2=a2;
}
    void transact(Account from,Account to,int amount){
        if(amount<0){
            System.out.println("FROM: " + from.getId());
            System.out.println("TO: " + to.getId());

            from.withdraw(amount);
            to.deposit(amount);

        }
        else{
            System.out.println("FROM: " + from.getId());
            System.out.println("TO: " + to.getId());

            to.withdraw(amount);
            from.deposit(amount);
        }

    }
}
