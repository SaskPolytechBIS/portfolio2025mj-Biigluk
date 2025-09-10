/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Review;

/**
 *
 * @author ibrah
 */
public abstract class BankAccount {
    private int AccountNumber;
    private float balance;
    private Customer customer;

    public BankAccount(int AccountNumber, float balance, Customer customer) {
        this.AccountNumber = AccountNumber;
        this.balance = balance;
        this.customer = customer;
    }
    public BankAccount(){
        
    }
    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void deposit(float amount){
        balance += amount;
    }
    public abstract void withdraw(float amount);
        
    public void transfer (BankAccount Other, float amount){
        withdraw(amount);
        Other.deposit(amount);
    }
}
