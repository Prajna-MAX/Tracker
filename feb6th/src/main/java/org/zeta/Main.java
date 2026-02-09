
package org.zeta;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.zeta.Bank.accountExists;
import static org.zeta.Bank.checkBal;
import static org.zeta.Loans.callLoan;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Object AddAccount;

    public static void main(String[] args) {
        int initialBal;
        System.out.println("give initial balance");
        Scanner sc=new Scanner(System.in);
        initialBal= sc.nextInt();
        validateAmount.v.val(initialBal);
        Bank bank=new Bank(12.2);
        LoanAccount account=new LoanAccount(123,initialBal);

        addAccount.accept(account);

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
                    validateAmount.v.val(dep);
                    executor.execute(new DepositTask(account,dep));
                    break;
                case 3:
                    System.out.println("Enter amount");
                    int with = sc.nextInt();
                    validateAmount.v.val(with);
                    executor.execute(new WithdrawTask(account,with));

                    break;
                case 4:
                    int a1=sc.nextInt();
                    validateAmount.v.val(a1);
                    int a2=sc.nextInt();
                    validateAmount.v.val(a2);
                    executor.execute(new WithdrawTask(account,a1));
                    executor.execute(new WithdrawTask(account,a2));
                    break;
                case 5:
                    System.out.println("enter id");
                    int id=sc.nextInt();
                    try {

                        if (accountExists.test(id) && checkBal.test(account)){
                            System.out.println("enter amount");
                            int amount = sc.nextInt();
                            validateAmount.v.val(amount);
                            System.out.println("enter tenure");
                            int tenure=sc.nextInt();
                            validateAmount.v.val(tenure);
                            Loans loans = new Loans(amount,tenure);
                            System.out.println("Interest after "+tenure+"yr" + callLoan.apply(amount));
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