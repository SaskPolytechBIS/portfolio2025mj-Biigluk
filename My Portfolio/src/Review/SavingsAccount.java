/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Review;

/**
 *
 * @author ibrah
 */
public class SavingsAccount extends BankAccount {
    private static float ACTIVITY_PENALTY = 5;
    private static int ACTIVITY_LIMIT = 10;
    
    private float minBalance;
    private float withdrawCount;

    public SavingsAccount(float minBalance, float withdrawCount, int AccountNumber, float balance, Customer customer) {
        super(AccountNumber, balance, customer);
        this.minBalance = minBalance;
        this.withdrawCount = withdrawCount;
    }

    public SavingsAccount(float minBalance, float withdrawCount) {
        this.minBalance = minBalance;
        this.withdrawCount = withdrawCount;
    }

    public static float getACTIVITY_PENALTY() {
        return ACTIVITY_PENALTY;
    }

    public static void setACTIVITY_PENALTY(float ACTIVITY_PENALTY) {
        SavingsAccount.ACTIVITY_PENALTY = ACTIVITY_PENALTY;
    }

    public static int getACTIVITY_LIMIT() {
        return ACTIVITY_LIMIT;
    }

    public static void setACTIVITY_LIMIT(int ACTIVITY_LIMIT) {
        SavingsAccount.ACTIVITY_LIMIT = ACTIVITY_LIMIT;
    }

    public float getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(float minBalance) {
        this.minBalance = minBalance;
    }

    public float getWithdrawCount() {
        return withdrawCount;
    }

    public void setWithdrawCount(float withdrawCount) {
        this.withdrawCount = withdrawCount;
    }
    public void withdraw (float amount){
        float fee = 0;
        if(getBalance()< minBalance && withdrawCount > ACTIVITY_PENALTY){
            fee = ACTIVITY_PENALTY;
        }
        if ((amount + fee <= getBalance()))
        {
            setBalance(getBalance()- (amount + fee));
        }
    }
    
}
