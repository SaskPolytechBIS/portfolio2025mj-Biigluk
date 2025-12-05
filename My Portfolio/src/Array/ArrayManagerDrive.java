/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Array;

import java.util.Scanner;
import Exceptions.*;   // Uses your NoItemsException and OutOfBoundsException

public class ArrayManagerDriver {

    public Scanner input;
    public static ArrayManager am;

    // Constructor
    public ArrayManagerDriver() {
        input = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ArrayManagerDriver driver = new ArrayManagerDriver();
        driver.getData();     // Fill ArrayManager with 9 integers

        int choice = 0;
        while (choice != 6) {    // 6 = Exit
            choice = driver.displayAction();
            driver.executeAction(choice);
        }
    }

    // Create ArrayManager with 9 integers
    public void getData() {
        am = new ArrayManager(9);

        // Add 9 integers (you can change these if you want)
        am.add(12);
        am.add(25);
        am.add(37);
        am.add(44);
        am.add(59);
        am.add(63);
        am.add(71);
        am.add(88);
        am.add(90);
    }

    // Show main menu and get user choice
    public int displayAction() {
        System.out.println("===== ARRAY MANAGER MENU =====");
        System.out.println("1. Display number of items");
        System.out.println("2. Display all items");
        System.out.println("3. Add an item");
        System.out.println("4. Add item at position");
        System.out.println("5. Remove item");
        System.out.println("6. Exit");
        System.out.print("-> ");

        int choice = input.nextInt();
        return choice;
    }

    // Execute menu choice (no switch, only if/else like your teacher)
    public void executeAction(int choice) {
        if (choice == 1) {
            MenuOption1();
        } else if (choice == 2) {
            MenuOption2();
        } else if (choice == 3) {
            MenuOption3();
        } else if (choice == 4) {
            MenuOption4();
        } else if (choice == 5) {
            MenuOption5();
        } else if (choice == 6) {
            Quit();
        } else {
            System.out.println("Invalid Selection. Please select a new option.");
        }
    }

    // 1. Display number of items
    public void MenuOption1() {
        System.out.println("Number of items in the array: " + am.size());
    }

    // 2. Display all items
    public void MenuOption2() {
        if (am.isEmpty()) {
            System.out.println("Array is empty.");
        } else {
            System.out.println("Items in the array:");
            am.print();   // Uses your ArrayManager.print()
        }
    }

    // 3. Add an item (at the end)
    public void MenuOption3() {
        System.out.print("Enter item to add: ");
        int value = input.nextInt();
        am.add(value);
        System.out.println("Item added.");
    }

    // 4. Add item at position
    public void MenuOption4() {
        System.out.print("Enter item to insert: ");
        int value = input.nextInt();
        System.out.print("Enter position (0 to " + am.size() + "): ");
        int pos = input.nextInt();

        try {
            am.insertAt(value, pos);
            System.out.println("Item inserted at position " + pos + ".");
        } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    // 5. Remove item
    public void MenuOption5() {
        System.out.print("Enter position to remove (0 to " + (am.size() - 1) + "): ");
        int pos = input.nextInt();

        try {
            am.remome(pos);
            System.out.println("Item removed from position " + pos + ".");
        } catch (OutOfBoundsException | NoItemsException e) {
            System.out.println(e.getMessage());
        }
    }

    // 6. Exit
    public void Quit() {
        System.out.println("Exiting...");
    }
}
