/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Review;

/**
 *
 * @author ibrah
 */
public class Customer extends Person{
    private int customerId;

    public Customer( int CustomerId, String Firstname, String Lastname, char MiddleInit) {
        super(Firstname, Lastname, MiddleInit);
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
}
