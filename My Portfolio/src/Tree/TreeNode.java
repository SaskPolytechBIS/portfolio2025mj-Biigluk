/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author ibrah
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    private Object data;

    public TreeNode(Object data) {
        this.data = data;
    }
    
public TreeNode(){}

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
