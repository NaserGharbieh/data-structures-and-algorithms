package trees;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable <? super T>>extends BinaryTree<T>  {



    public BinarySearchTree() {
        super();
    }


    public boolean Contains(Integer value){
     Node  temproot =root;
     while (temproot!=null) {
         if (temproot.value == value) {
             return true;
         } else if ((Integer) temproot.value < value) {
             temproot = temproot.right;
         } else temproot = temproot.left;
     }
     return false; }



}
