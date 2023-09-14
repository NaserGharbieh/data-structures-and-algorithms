package stack;

public class MaxStack {
    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
    MaxStack max=new MaxStack();
    private Node top=null;
    public boolean isempty(){
        return top==null;
    }
    public void push(int value){
        Node newNode=new Node(value);
        if(isempty()){
            top=newNode;
            max.push(value);
        }
        else{
            newNode.next=top;
            top=newNode;
            if(value>=max.peek())
                max.push(value);
        }

    }
    public int pop(){

        if(isempty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int temp=top.val;
        top=top.next;
        if(temp==max.peek())
            max.pop();
        return  temp;


    }

    public int  peek(){
        if(isempty()) {
            throw new IllegalStateException("Stack is empty");
        }


        return  top.val;
    }



    public int getMax(){

        return max.peek();}


}
