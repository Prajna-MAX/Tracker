package org.zeta;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void validateAmount(int amt){
        try{
            if(amt<=0)throw new Exception("Less amt");
        }catch (Exception e){
            System.out.println("negative amount");
        }
    }
    public static void main(String[] args) {
        int initialBal;
        System.out.println("give initial balance");
        Scanner sc=new Scanner(System.in);
        initialBal= sc.nextInt();
        validateAmount(initialBal);
        Account account=new Account(initialBal);

        ExecutorService executor= Executors.newFixedThreadPool(3);

        while (true){
            System.out.println("MULTITHREADED BANKING SYSTEM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Simulate Parallel Withdrawals");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int i=sc.nextInt();

            switch (i){
                case 1:
                    int amt=account.getBal();
                    System.out.println(amt);
                    break;
                case 2:
                    System.out.println("Enter amount");
                    int dep= sc.nextInt();
                    validateAmount(dep);
                    executor.execute(new DepositTask(account,dep));
                    break;
                case 3:
                    System.out.println("Enter amount");
                    int with = sc.nextInt();
                    validateAmount(with);
                    executor.execute(new WithdrawTask(account,with));

                    break;
                case 4:
                    int a1=sc.nextInt();
                    validateAmount(a1);
                    int a2=sc.nextInt();
                    validateAmount(a2);
                    executor.execute(new WithdrawTask(account,a1));
                    executor.execute(new WithdrawTask(account,a2));
                    break;

                case 5:
                    executor.shutdown();
            }
        }
    }
}