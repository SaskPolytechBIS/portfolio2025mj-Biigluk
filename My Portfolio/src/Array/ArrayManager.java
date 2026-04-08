/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Array;
import Exceptions.*;
/**
 *
 * @author ibrah
 */
public class ArrayManager {

    private Object[] items;
    private int count;

    public ArrayManager() {
        items = new Object[10];
        count = 0;
    }

    public ArrayManager(int size) {
        items = new Object[size];
        count = 0;
    }

    public ArrayManager(Object[] items) {
        this.items = items;
        count = items.length;
    }

    public void add(Object o) {
        if (count < items.length) {
            resize();
        }

        //add the new items
        items[count] = o;
        count++;

    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void printItems() {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
//        if (count == 0) {
//            return true;
//        } else {
//            return false;
//        }
    }

    public void resize() {
        Object[] temp = new Object[items.length + 10];

        // 2. Copy everything into a new array
        System.arraycopy(items, 0, temp, 0, items.length);

        // 3. Point old array to new array
        items = temp;

    }

    public void insertAt(Object o, int pos) throws OutOfBoundsException {
        if (pos < 0 || pos > count) { // Checks for an OutOfBoundsException
            throw new OutOfBoundsException("Cannot Insert item outside of collection bounds");
        }
        
        if (count >= items.length) {
            resize();
        }
        System.arraycopy(items, pos, items, pos + 1, count - pos);
        items[pos] = o;
        count++;
//        Object[] temp = new Object[items.length + 5];
//
//        // 2. Copy everything into a new array
//        System.arraycopy(items, 0, temp, 0, items.length);
//
//        // 3. Point old array to new array
//        items = temp;
//        //add the new items
//        items[pos] = 66;
//        count++;
    }
    public void remome(int pos)throws OutOfBoundsException,NoItemsException{
        if (pos < 0 || pos > count) { // Checks for an OutOfBoundsException
            throw new OutOfBoundsException("Cannot Insert item outside of collection bounds");
        }

if (count == 0) { // Checks for a NoItemsException
            throw new NoItemsException("Remove Failed. Collection is empty.");
        }
        // copy everything from pos to count, back 1 space
      System.arraycopy(items, pos +1, items, pos,count-pos);
        
        count--;
    }
    
    public int findLargest()
    {
        int pos = 0;
        for (int i = 0; i < count; i++) {
            Comparable c = (Comparable) items[i];
            if (c.compareTo(items[pos]) > 0) {
                pos = i;
            }
        }
        return pos;
    }
    public int find(Object o) {
        for (int i = 0; i < count; i++) {
            if (items[i].equals(o)) {
                return i;
            }
        }

        return -1;

    }
}
