/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkLists;

/**
 *
 * @author ibrah
 */
public class LinkedList {

    private ListNode start;
    private ListNode current;

    public LinkedList() {
    }

    public ListNode getCurrent() {
        return current;
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
            current.next = temp;
            current = current.next;
        }
    }

    public void print() {
        ListNode temp = start;

        while (temp != null) {

            System.out.println("Data: " + temp.getData());
            temp = temp.next;
        }

    }

}
