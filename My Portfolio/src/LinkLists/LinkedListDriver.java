/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LinkLists;

import java.util.Scanner;
import Exceptions.*;

/**
 *
 * @author ibrah
 */
public class LinkedListDriver {

    private Scanner input;
    private LinkedList list;

    public LinkedListDriver() {
        input = new Scanner(System.in);
        list = new LinkedList();
    }

    public static void main(String[] args) {
        LinkedListDriver ld = new LinkedListDriver();
        ld.getData();
        int choice = -1;

        while (choice != 7) {
            choice = ld.displayAction();
            ld.executeAction(choice);
        }
        System.out.println("System Exiting...");
    }

    public void getData() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
    }

    public int displayAction() {
        System.out.println();
        System.out.println("===== LINKED LIST MENU =====");
        System.out.println("1. Display item at a position");
        System.out.println("2. Show all items");
        System.out.println("3. Add item AFTER current");
        System.out.println("4. Add item at the END");
        System.out.println("5. Add item BEFORE current");
        System.out.println("6. Remove current item");
        System.out.println("7. Quit");
        System.out.print("-> ");

        int choice = input.nextInt();
        return choice;
    }

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
            MenuOption6();
        } else if (choice == 7) {
            return; //Handled in main
        } else {
            System.out.println("Invalid Selection. Please Select a New Option");
        }
    }

    // 1. Display item at a position (0 to size-1)
    public void MenuOption1() {
        if (list.size() == 0) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("There are " + list.size() + " items.");
        System.out.println("Positions go from 0 to " + (list.size() - 1));
        System.out.print("Enter the position of the item: ");
        int pos = input.nextInt();

        try {
            Object item = list.getItemAt(pos);
            System.out.println("Item at position " + pos + ": " + item);
        } catch (OutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // 2. Print all items
    public void MenuOption2() {
        if (list.size() == 0) {
            System.out.println("List is empty.");
        } else {
            list.print();
        }
    }

    // 3. Add item AFTER current
    public void MenuOption3() {
        System.out.print("Enter a value to add after current: ");
        Object value = input.next();
        list.addAfter(value);
        displayCurrent();
    }

    // 4. Add item at END
    public void MenuOption4() {
        System.out.print("Enter a value to add at the end: ");
        Object value = input.next();
        list.end();
        list.add(value);
        displayCurrent();
    }

    // 5. Add item BEFORE current
    public void MenuOption5() {
        System.out.print("Enter a value to add before current: ");
        Object value = input.next();
        list.addBefore(value);
        displayCurrent();
    }

    // 6. Remove current item
    public void MenuOption6() {
        try {
            if (list.size() == 0) {
                System.out.println("Nothing to remove");
                return;
            }

            System.out.println("Removing current item...");
            Object removed = list.getCurrent();
            list.removeCurrent();
            System.out.println("Removed: " + removed);
            displayCurrent();

        } catch (NoItemsException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    // Show current item after each edit
    public void displayCurrent() {
        try {
            System.out.println("Current Item: " + list.getCurrent());
        } catch (Exception ex) {
            System.out.println("No current item selected");
        }
    }
}
