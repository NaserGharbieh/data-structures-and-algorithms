package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
       int maxNumber =maxlist.get(0).intValue();
        for (int number :maxlist){
            if(number> maxNumber)
                maxNumber =number;
        }
    return maxNumber;
    }

    public static   List<Integer> bfs(BinaryTree t){
        List<Integer>ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(t.root);
        while(q.size() != 0){
            int length = q.size();
            for(int i = 0 ;i<length;i++){

                if(q.peek().left!=null){
                    q.add(q.peek().left);

                }
                if(q.peek().right!=null){
                    q.add(q.peek().right);
                }
                ans.add((Integer) q.remove().value);
            }
        }
        return ans;
    }








}
