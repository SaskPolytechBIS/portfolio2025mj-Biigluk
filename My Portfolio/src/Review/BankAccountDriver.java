/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Review;

import java.util.Scanner;

/**
 *
 * @author ibrah
 */
public class BankAccountDriver {

    private Scanner input;
    private BankAccount[] accounts;
    private Customer[] customers;

    public static void main(String[] args) {

        // Create new instance of the Driver
        BankAccountDriver bad = new BankAccountDriver();

        //
        bad.initData();
        bad.run();

    }

    // Initializes the Scanner
    public BankAccountDriver() {
        input = new Scanner(System.in);
    }

    public void run() {

        System.out.println("Enter Customer ID: ");
        int Id = input.nextInt();

        Customer c = getCustomerById(Id);

        int action = -1;

        while (action != 4) {
            displayAccountsForCustomer(c);
            System.out.println("Select an Account");
            int AccountID = input.nextInt();
            BankAccount B = getBankAccountByAccountNumber(AccountID);

            action = showActionMenu();
            executeAction(action, B);

        }

    }

    public void initData() {

        // Creates an Array of Customer
        customers = new Customer[3];

        // Creates the Customer
        customers[0] = new Customer(1, "Ryan", "Longworth", 'T');
        customers[1] = new Customer(2, "John", "Smith", 'A');
        customers[2] = new Customer(3, "Bill", "Clause", 'F');

        // Creates an Array of Accounts
        accounts = new BankAccount[4];

        // Creates the Accounts
        accounts[0] = new ChequingAccount(2, 500, 111, 1100.50f, customers[0]);
        accounts[1] = new ChequingAccount(2, 500,221, 1100.50f, customers[1]);
        accounts[2] = new SavingsAccount(2, 500, 434, 1100.50f, customers[2]);
        accounts[3] = new SavingsAccount(2, 500, 193322, 1100.50f, customers[0]);
    }

    public int showActionMenu() {
        int Option = 0;

        // Menu
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Quit");

        // Gets Option from User
        Option = input.nextInt();

        return Option;
    }

    public void executeAction(int action, BankAccount BA) {

        // Will do corresponding action depending on User Choice in the Menu
        if (action == 1) {
            deposit(BA);
        } else if (action == 2) {
            withdraw(BA);
        } else if (action == 3) {
            transfer(BA);
        } else if (action == 4) {
            quit();
        } else {
            System.out.println("Invalid action. Try Again");
        }

    }

    // Deposit
    public void deposit(BankAccount BA) {
        System.out.println("Deposit Amount: ");
        float amount = input.nextFloat();
        BA.deposit(amount);
        System.out.println("End Balance: " + BA.getBalance());
    }

    // Withdraw
    public void withdraw(BankAccount BA) {
        System.out.println("Withdraw Amount: ");
        float amount = input.nextFloat();
        BA.withdraw(amount);
        System.out.println("End Balance: " + BA.getBalance());
    }

    // Transfer
    public void transfer(BankAccount BA) {
        System.out.println("Enter target Account Number: ");
        int AccountID = input.nextInt();
        BankAccount TargetAccount = getBankAccountByAccountNumber(AccountID);
        System.out.println("How much to Transfer: ");
        float amount = input.nextFloat();
        BA.transfer(TargetAccount, amount);
    }

    // Quits
    public void quit() {
        System.out.println("Exiting... ");
    }

    public BankAccount getBankAccountByAccountNumber(int AccountID) {

        BankAccount b = null;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getAccountNumber() == AccountID) {
                b = accounts[i];
            }
        }

        return b;
    }

    public Customer getCustomerById(int ID) {
        Customer c = null;

        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getCustomerId() == ID) {
                c = customers[i];
            }
        }
        return c;
    }

    public void displayAccountsForCustomer(Customer c) {

        int num = 0;

        for (int i = 0; i < customers.length; i++) {
            if (accounts[i].getCustomer().getCustomerId() == c.getCustomerId()) {
                System.out.println("Account Number: " + accounts[i].getAccountNumber());
                num++;
            }
        }

        if (num == 0) {
            System.out.println("No Accounts for this Customer.");
        }
    }
}
