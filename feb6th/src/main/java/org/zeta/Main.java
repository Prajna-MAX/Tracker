
package org.zeta;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.zeta.Bank.*;
import static org.zeta.Loans.callLoan;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Object AddAccount;

    public static void main(String[] args) {
        int initialBal;
        System.out.println("give initial balance");
        Scanner sc = new Scanner(System.in);
        initialBal = sc.nextInt();
        validateAmount.v.val(initialBal);
        Bank bank = new Bank(12.2);
        Account account = new Account(123, initialBal);

        addAccount.accept(account);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        while (true) {
            System.out.println("MULTITHREADED BANKING SYSTEM");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Simulate Parallel Withdrawals");
            System.out.println("5. Loans");
            System.out.println("6. Transaction");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int option;
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("Input cannot be a string");
            }

            switch (option) {
                case 1:
                    System.out.println("Enter accId");
                    int id = sc.nextInt();

                    try {
                        Account acc = accounts.get(id);
                        if (acc != null) {
                            int amt = acc.getBal();
                            System.out.println("Balance: " + amt);
                        } else {
                            throw new Exception("No account with id " + id);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    System.out.println("Enter accId");
                    int id1 = sc.nextInt();

                    try {
                        Account acc = accounts.get(id1);
                        if (acc != null) {
                            System.out.println("Enter amount");
                            int dep = sc.nextInt();
                            validateAmount.v.val(dep);

                            executor.execute(new DepositTask(account, dep));
                        } else {
                            throw new Exception("No account with id " + id1);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter amount");
                    int with = sc.nextInt();
                    validateAmount.v.val(with);
                    executor.execute(new WithdrawTask(account, with));

                    break;
                case 4:
                    int a1 = sc.nextInt();
                    validateAmount.v.val(a1);
                    int a2 = sc.nextInt();
                    validateAmount.v.val(a2);
                    executor.execute(new WithdrawTask(account, a1));
                    executor.execute(new WithdrawTask(account, a2));
                    break;
                case 5:
                    System.out.println("enter id");
                    int accid = sc.nextInt();
                    try {

                        if (accountExists.test(accid) && checkBal.test(account)) {
                            System.out.println("enter amount");
                            int amount = sc.nextInt();
                            validateAmount.v.val(amount);
                            System.out.println("enter tenure");
                            int tenure = sc.nextInt();
                            validateAmount.v.val(tenure);
                            Loans loans = new Loans(amount, tenure);
                            System.out.println("Interest after " + tenure + "yr" + callLoan.apply(amount));
                        } else throw new Exception("Criteria doesnt match");
                    } catch (Exception e) {
                        System.out.println("Criteria doesnt match");
                        ;
                    }
                    break;
                case 6:
                    Account account2 = new Account(234, 2000);
                    accounts.put(234,account2);
                    Transaction t = new Transaction(account, account2);
                    System.out.println("Enter amount for transaction");
                    int amount = sc.nextInt();
                    t.transact(account, account2, amount);

                    break;


                case 7:
                    executor.shutdown();
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}
