/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author ibrah
 */
public class Tree {

    //Like items in a link List
    private TreeNode root;
    public int searchCount = 0;

    public void addNode(TreeNode current, Object o) {
        //need to make comparable 
        Comparable c = (Comparable) o;
        if (root == null) {
            root = new TreeNode(o);
        } else if (c.compareTo(current.getData()) < 0) {
            if (current.left == null) {
                current.left = new TreeNode(o);
            } else {
                addNode(current.left, o); // ReCURSION
            }
        } else if (c.compareTo(current.getData()) > 0) {
            if (current.right == null) {
                current.right = new TreeNode(o);
            } else {
                addNode(current.right, o);// ReCURSION
            }
        }
    }

    public void addNode(Object o) {
        addNode(root, o);
    }

    public void printTree(TreeNode current) {
        if (current.left != null) {
            printTree(current.left);
        }
        System.out.println(current.getData());

        if (current.right != null) {
            printTree(current.right);
        }
    }

    public void printTree() {
        printTree(root);
    }

    public Object searchTree(TreeNode current, Object o) {
        searchCount++;
        Comparable c = (Comparable) o;

        if (c.compareTo(current.getData()) == 0) {
            return current.getData();

        } else if (c.compareTo(current.getData()) < 0 && current.left != null) {

            return searchTree(current.left, o);
        } else if (c.compareTo(current.getData()) > 0 && current.right != null) {
            return searchTree(current.right, o);
        } else {
            return null;
        }
    }

    public Object searchTree(Object o) {
        return searchTree(root, o);

    }
}
