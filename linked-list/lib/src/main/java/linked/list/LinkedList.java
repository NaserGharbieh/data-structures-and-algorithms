package linked.list;

public class LinkedList {
    public class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head = null;


    private boolean isEmpty() {
        return (head == null);
    }

    void insert(int val) {
        if (isEmpty()) {
            head = new Node(val);
//            tail = head;

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
}
