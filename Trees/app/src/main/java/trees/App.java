/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package trees;

import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {
        BinarySearchTree <Integer> tree=new BinarySearchTree<Integer>();

        tree.root=new Node<Integer>(5);
        tree.root.right = new Node<Integer>(6);
        tree.root.left=new Node(4);


        System.out.println(tree.findMaximumValue());


    }
}