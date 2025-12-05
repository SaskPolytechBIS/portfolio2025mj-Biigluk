/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tree;

/**
 *
 * @author ibrah
 */
public class TreeDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Tree t = new Tree();

        for (int i = 0; i < 30; i++) {
            int num = (int) (Math.random() * 200);
            System.out.println(num + " ");
            t.addNode(num);
        }

        System.out.println("----------------");
        t.printTree();

        System.out.println("searching Tree for 104  " + t.searchTree(104));

        System.out.println("104 found after " + t.searchCount + " calls ");
    }

}
