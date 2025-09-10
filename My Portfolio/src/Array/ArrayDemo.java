/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Array;

/**
 *
 * @author ibrah
 */
public class ArrayDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       ArrayManager am = new ArrayManager(5);
       am.add(12);
       am.add(14);
       am.add(77);
       am.add(55);
       am.add(58);
       am.add(67);
       am.print();
        System.out.println("----------");
        am.printItems();
        System.out.println("-------------");
        am.insertAt(6, 2);
        am.print();
        System.out.println("-----------");
        am.print();
        // Creating an array
        int[] items = new int[5];

        // Filling the array
        items[0] = 1;
        items[1] = 2;
        items[2] = 3;
        items[3] = 4;
        items[4] = 5;

        // Can also do it like the following
        /*
        int[] items = {1,2,3,4,5};
         */
        // Printing the whole array
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }

        System.out.println("-----");

        // Adding more into an already full array
        // 1. Make a bigger array
        int[] temp = new int[items.length + 1];

        // 2. Copy everything into a new array
        System.arraycopy(items, 0, temp, 0, items.length);

        // 3. Point old array to new array
        items = temp;

        // 5. Add the new item
        items[5] = 6;

        // Printing the whole array
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
      
    }

}
