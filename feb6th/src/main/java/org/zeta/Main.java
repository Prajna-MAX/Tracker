package org.zeta;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.zeta.Bank.*;
import static org.zeta.Loans.callLoan;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        int counter=1;
        while (true) {
            printMenu();
            int option = readInt(sc, "Enter your choice: ");

            switch (option) {
                case 1 -> createAccount(sc);
                case 2 -> transferMoney(sc);
                case 3 -> viewTransactions(sc);
                case 4->viewAllAccounts();
                case 5 -> handleLoans(sc);
                case 6 -> {
                    executor.shutdown();
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }


    private static void printMenu() {
        System.out.println("\n--- BANKING SYSTEM ---");
        System.out.println("1. Create Account");
        System.out.println("2. Transfer Money");
        System.out.println("3. View Transactions");
        System.out.println("4. View Account");
        System.out.println("5. Loans");
        System.out.println("6. Exit");
    }



    private static int readInt(Scanner sc, String msg) {
        System.out.print(msg);
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input! Enter a number: ");
                sc.nextLine();
            }
        }
    }

    private static void viewAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("\n--- List of Accounts ---");

        for (Account acc : accounts.values()) {
            System.out.println("Account ID: " + acc.getId() +
                    " | Balance: " + acc.getBal());
        }
    }


    private static void createAccount(Scanner sc) {

        int id = readInt(sc, "Enter Account ID: ");

        if (accounts.containsKey(id)) {
            System.out.println("Account already exists!");
            return;
        }

        int balance = readInt(sc, "Enter Initial Balance: ");

        try {
            validateAmount.v.val(balance);

            Account acc = new Account(id, balance);
            addAccount.accept(acc);

            System.out.println("Account Created Successfully!");

        } catch (Exception e) {
            System.out.println("Invalid amount: " + e.getMessage());
        }
    }



    private static void transferMoney(Scanner sc) {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        System.out.println("Available Accounts: " + accounts.keySet());

        int fromId = readInt(sc, "Enter YOUR account ID: ");
        int toId = readInt(sc, "Enter RECEIVER account ID: ");

        if (!accounts.containsKey(fromId) || !accounts.containsKey(toId)) {
            System.out.println("Invalid account ID(s)");
            return;
        }

        if (fromId == toId) {
            System.out.println("Cannot transfer to the same account!");
            return;
        }

        int amount = readInt(sc, "Enter transfer amount: ");

        try {
            validateAmount.v.val(amount);
            if (accounts.get(fromId).getBal() < amount)
                throw new IllegalArgumentException("Insufficient balance for transfer!");
            Account fromAcc = accounts.get(fromId);
            Account toAcc = accounts.get(toId);

            if (fromAcc.getBal() < amount) {
                throw new IllegalArgumentException("Insufficient balance for transfer!");
            }

            Transaction t = new Transaction(fromAcc, toAcc);
            t.transact(fromAcc, toAcc, amount);

            System.out.println("Transfer Successful!");
        } catch (Exception e) {
            System.out.println("Transfer Failed: " + e.getMessage());
        }
    }




    private static void viewTransactions(Scanner sc) {

        int id = readInt(sc, "Enter Account ID: ");
        Account acc = accounts.get(id);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        List<String> history = acc.getTransactions();

        if (history.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\nTransaction History for Account " + id);
        history.forEach(System.out::println);
    }



    private static void handleLoans(Scanner sc) {

        int accId = readInt(sc, "Enter account ID: ");
        Account acc = accounts.get(accId);

        try {
            if (acc != null && accountExists.test(accId) && checkBal.test(acc)) {
                int amount = readInt(sc, "Enter loan amount: ");
                validateAmount.v.val(amount);

                int tenure = readInt(sc, "Enter tenure (years): ");
                validateAmount.v.val(tenure);

                System.out.println("Interest after "
                        + tenure + " yr: " + callLoan.apply(amount));
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Criteria not met for loan");
        }
    }
}
