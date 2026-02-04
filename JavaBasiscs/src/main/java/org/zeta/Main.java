package org.zeta;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Account acc1=new SavingAccount(100) ;
    Account acc2=new SavingAccount(200);
    acc1.deposit(1000);
        System.out.println(acc1.getBalance());

    Transaction trans=new Transaction();
        trans.transact(acc1,acc2,200);

        System.out.println(acc1.getBalance());
    }
}