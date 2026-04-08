/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkLists;

import Exceptions.*;

/**
 *
 * @author ibrah
 */
public class LinkedList {

    private ListNode start;
    private ListNode current;
    private int count;

    public LinkedList() {
    }

    public Object getCurrent() {
        return current.getData();
    }

    public void setCurrent(ListNode current) {
        this.current = current;
    }

    public void add(Object item) {

        ListNode temp = new ListNode(item);

        if (start == null) {
            start = temp;
            current = start;
        } else {
            end();
            current.next = temp;
            current = current.next;
        }
        count++;
    }

    public void print() {
        ListNode temp = start;

        while (temp != null) {

            System.out.println("Data: " + temp.getData());
            temp = temp.next;
        }

    }

    public int size() {
        return count;
    }

    public void start() {
        current = start;
    }

    public void advance() throws OutOfBoundsException {
        if (current.next == null) {
            throw new OutOfBoundsException();
        } else {
            current = current.next;
        }

    }

    public void end() {
        current = start;
        while (current.next != null) {

            try {
                advance();

            } catch (OutOfBoundsException OOBE) {
                System.out.println("ERROR:" + OOBE.getMessage());
            }
        }
    }

    public void addAfter(Object item) {
        ListNode temp = new ListNode(item);
        if (start == null) {
            start = temp;
            current = temp;
        } else {
            temp.next = current.next;
            current.next = temp;
            current = temp;

        }
        count++;

    }

    public void removeCurrent() throws NoItemsException {
        if (start == null) {
            throw new NoItemsException();
        } else if (current == start) {
            start = start.next;

        } else {
            ListNode temp = start;
            while (temp.next != current) {
                temp = temp.next;

            }
            temp.next = temp.next.next;
            current = temp;
        }

    }

    public void addBefore(Object Item) {
        ListNode node = new ListNode(Item);
        if (start == null) {
            start = node;
            current = start;
        } else if (current == start) {
            node.next = current;
            start = node;
            current = node;
        } else {
            ListNode temp = start;

            while (temp.next != current) {
                temp = temp.next;
            }
            node.next = current;
            temp.next = node;
            current = node;
        }
        count++;
    }
    public Object getItemAt(int pos) throws OutOfBoundsException {
        if (pos < 0 || pos > count) {
            throw new OutOfBoundsException("cannot Retrieve outside of bounds");

        }
        ListNode temp = start;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp.getData();
    }
}
