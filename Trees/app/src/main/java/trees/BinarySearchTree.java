package trees;

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
    public void add(Integer value){
     Node  temproot =root;
     Node  current=null;
     Node addedNode=new Node<>(value);

     if (root==null){
         root=addedNode;
         return;
     }

     while (temproot!=null) {
         current =temproot;
         if ((Integer )temproot.value == value) {
             return;
         }else if ((Integer) temproot.value < value) {
             temproot = temproot.right;
         } else temproot = temproot.left;
     }


        if ((Integer )current.value < value) {
            current.setRight(addedNode);
        }
        else current.setLeft(addedNode);

      }



}
