/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Review;

/**
 *
 * @author ibrah
 */
public class ChequingAccount extends BankAccount{
    private float overDraftPenalty;
    private float overDraftLimit;

    public ChequingAccount(float overDraftPernalty, float overDraftLimit, int AccountNumber, float balance, Customer customer) {
        super(AccountNumber, balance, customer);
        this.overDraftPenalty = overDraftPernalty;
        this.overDraftLimit = overDraftLimit;
    }

    public float getOverDraftPernalty() {
        return overDraftPenalty;
    }

    public void setOverDraftPernalty(float overDraftPernalty) {
        this.overDraftPenalty = overDraftPernalty;
    }

    public float getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(float overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }
   public void withdraw (float amount){
       if(amount<=getBalance()){
           setBalance(getBalance() -amount);
           
       }else{
           if(amount <= getBalance()+ overDraftLimit){
             setBalance (getBalance() - (amount + overDraftPenalty));
       }
       else{
           System.out.println("you have gone over your draft limit"); 
               }
   }
    
}
}