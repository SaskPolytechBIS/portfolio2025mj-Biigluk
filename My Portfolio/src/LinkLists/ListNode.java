/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkLists;

/**
 *
 * @author ibrah
 */
public class ListNode {
    
   private Object data;
   public ListNode next;
   
   public ListNode (Object data){
       this.data =data;
   }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
    public ListNode(){
        
    }
}
