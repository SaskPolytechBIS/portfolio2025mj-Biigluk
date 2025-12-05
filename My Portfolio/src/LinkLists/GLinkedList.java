/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkLists;

/**
 *
 * @author ibrah
 */
public class GLinkedList<T> {
    
    private GListNode<T> items;
    private GListNode<T> current;

    public void add(T item) {
        if (items == null) {
            items = new GListNode(item);
            current = items;
        } else {
            current.next = new GListNode(item);
            current = current.next;
        }
    }

    public void print() {
        GListNode<T> temp = items;
        while (temp != null) {
            System.out.println("Data: " + temp.getData());
            temp = temp.next;
        }
    }
}
