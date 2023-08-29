package linked.list;

public class LinkedList {
    public class Node {
        int val;
        Node next;

        Node(int val) {
            this.val= val;
        }
    }

    private Node head = null;
    private Node tail = null;


    private boolean isEmpty() {
        return (head == null);
    }

    void insert(int val) {
        if (isEmpty()) {
            head = new Node(val);

           tail = head;


        } else {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;

        }

    }
    boolean Includes(int val) {
        Node temp=head;
        while (temp != null) {

            if(temp.val==val)return true;

            temp = temp.next;
        }

        return false;
    }
    public void append(int val){
        if (isEmpty()){
            insert(val);
        }else {
        Node newNode=new Node(val);
        tail.next=newNode;
        newNode.next=null;
        tail=newNode; }
    }
    public void insertBefore(int val,int newVal){
        if(!Includes(val)){
            return ;
        }
        if(head.val==val){
            insert(newVal);
            return ;
        }
        Node temp=head;
        while(temp.next.val !=val){
            temp=temp.next;
        }
        Node newNode = new Node(newVal);
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public void insertAfter(int val , int newVal){
        if(!Includes(val)){
            return ;
        }
        if(tail.val==val){
            append(newVal);
            return ;
        }
        Node temp=head;
        while(temp.val !=val){
            temp=temp.next;
        }
        Node newNode = new Node(newVal);
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public int kthFromEnd(int k) {
        if (isEmpty() || k < 0) {
            throw new IllegalArgumentException("Invalid input or linked list is empty");
        }

        Node firstPointer = head;
        Node secondPointer = head;

        // Move the first pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (firstPointer == null) {
                throw new IllegalArgumentException("k is greater than the length of the linked list");
            }
            firstPointer = firstPointer.next;
        }

        // Handle the case where k is equal to the length of the list
        if (firstPointer == null) {
            throw new IllegalArgumentException("k is equal to the length of the linked list");
        }

        // Move both pointers until the first pointer reaches the end
        while (firstPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return secondPointer.val;
    }



    @Override
    public String toString() {
        String print = "";
        if (isEmpty()) {
            print="linked list is empty!!";

        } else {
            Node temp = head;

            while (temp != null) {

                print += temp.val;
                print += " -> ";
                temp = temp.next;
            }
            print += "NULL";

        }

        return print;
    }

    public static void main(String[] args) {
        LinkedList l=new LinkedList();   //empty
        System.out.println( l.toString()+"\n\n");
        System.out.println(l.Includes(5)+"\n\n");


        l.insert(1);    //single element 
        System.out.println( l.toString()+"\n\n");
        System.out.println(l.Includes(2)+"\n\n");
        System.out.println(l.Includes(1));

        l.insert(4);
        l.insert(3);
        l.insert(2); // 4 elements 
        System.out.println( l.toString()+"\n\n");
        System.out.println(l.Includes(4)+"\n\n");
        System.out.println(l.Includes(5));
    }
    }

