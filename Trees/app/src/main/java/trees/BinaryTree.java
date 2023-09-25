package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
    public Node<T>root;
   


    public BinaryTree() {
        root=null;
    }

    private void preOrderTraversal (Node node , List<T> answer){
        if(node==null){
            return ;
        }
        else { answer.add((T) node.value);
            preOrderTraversal(node.left , answer);
            preOrderTraversal(node.right , answer);
        }
    }
    public void preOrderTraversal ( List<T> answer){
        preOrderTraversal(root,answer);
    }
 private void inOrderTraversal (Node node , List<T> answer){
        if(node==null){
            return ;
        }
        else {
            inOrderTraversal(node.left , answer);
            answer.add((T) node.value);
            inOrderTraversal(node.right , answer);
        }
    }
    public void inOrderTraversal ( List<T> answer){
        inOrderTraversal(root,answer);
    }
 private void postOrderTraversal (Node node , List<T> answer){
        if(node==null){
            return ;
        }
        else {
            postOrderTraversal(node.left , answer);
            postOrderTraversal(node.right , answer);
            answer.add((T) node.value);
        }
    }
    public void postOrderTraversal ( List<T> answer){
        postOrderTraversal(root,answer);
    }

    public int findMaximumValue (){
        List<Integer> maxlist=new ArrayList<>() ;

        this.inOrderTraversal((List<T>) maxlist);
       int max=maxlist.get(0).intValue();
        for (int number :maxlist){
            if(number>max)
                max=number;
        }
    return max;
    }








}
