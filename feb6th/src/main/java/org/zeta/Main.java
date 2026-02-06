package org.zeta;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        int initialBal;
        System.out.println("give initial balance");
        Scanner sc=new Scanner(System.in);
        initialBal= sc.nextInt();
        validateAmount.validate(initialBal);
        Bank bank=new Bank(12.2);
        LoanAccount account=new LoanAccount(123,initialBal);

        bank.addAccount(account);

        ExecutorService executor= Executors.newFixedThreadPool(3);

        while (true){
            System.out.println("MULTITHREADED BANKING SYSTEM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Simulate Parallel Withdrawals");
            System.out.println("5. Loans");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int option=sc.nextInt();

            switch (option){
                case 1:
                    int amt=account.getBal();
                    System.out.println(amt);
                    break;
                case 2:
                    System.out.println("Enter amount");
                    int dep= sc.nextInt();
                    validateAmount.validate(dep);
                    executor.execute(new DepositTask(account,dep));
                    break;
                case 3:
                    System.out.println("Enter amount");
                    int with = sc.nextInt();
                    validateAmount.validate(with);
                    executor.execute(new WithdrawTask(account,with));

                    break;
                case 4:
                    int a1=sc.nextInt();
                    validateAmount.validate(a1);
                    int a2=sc.nextInt();
                    validateAmount.validate(a2);
                    executor.execute(new WithdrawTask(account,a1));
                    executor.execute(new WithdrawTask(account,a2));
                    break;
                case 5:
                    System.out.println("enter id");
                    int id=sc.nextInt();
                    try {
                        if (Bank.checkAcc(id) && Bank.checkBal(account)){
                            System.out.println("enter amount");
                            int amount = sc.nextInt();
                            System.out.println("enter tenure");
                            int tenure=sc.nextInt();
                            Loans loans = new Loans(amount,tenure);
                            System.out.println("Interest after "+tenure+"yr" + loans.callLoan(amount));
                        }
                        else throw new Exception("Criteria doesnt match");
                    } catch (Exception e) {
                        System.out.println("Criteria doesnt match");;
                    }
                case 6:
                    executor.shutdown();
                    break;
                    default:
                    System.out.println("Invalid choice");

            }
        }
    }
}