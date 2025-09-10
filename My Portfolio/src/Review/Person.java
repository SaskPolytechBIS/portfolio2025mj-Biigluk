/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Review;

/**
 *
 * @author ibrah
 */
public class Person {
    private String Firstname;
    private String Lastname;
    private char MiddleInit;

    public Person(String Firstname, String Lastname, char MiddleInit) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.MiddleInit = MiddleInit;
    }
    public Person(){
        
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public char getMiddleInit() {
        return MiddleInit;
    }

    public void setMiddleInit(char MiddleInit) {
        this.MiddleInit = MiddleInit;
    }
    public String Fullname(){
     return Firstname + " " + Lastname + " " + MiddleInit +"";
        
    }
    
}
