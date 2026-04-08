/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Comparisons;
import Review.Person;
import Array.ArrayManager;

/**
 *
 * @author ibrah
 */
public class ComparisonsDemo{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Widget[] widget = new Widget[4];
        widget[0] = new Widget(1, "Thingy", 12);
        widget[1] = new Widget(1, "Dohickey", 22);
        widget[2] = new Widget(1, "Thingamajig",112);
        widget[3] = new Widget(1, "Stuff", 6);
       
       ArrayManager am = new ArrayManager(widget);
       am.print();
       
      System.out.println(am.findLargest());
      
         Widget items = new Widget(5,"Dohickey", 22);
         System.out.println(am.find(items));
        
    }
//        Person p1 = new Person("John", "Doe", 'T');
//        Person p2 = new Person("John", "Doe", 'T');
//        // TODO code application logic here
//
//        if (p1 == p2) {
//            System.out.println("equal");
//        } else {
//            System.out.println("not equal");
//        }
//        System.out.println("p1: " + p1);
//        System.out.println("p1: " + p2);
//    }

}
