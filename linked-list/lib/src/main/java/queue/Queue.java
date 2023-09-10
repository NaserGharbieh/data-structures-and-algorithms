package queue;

public class Queue<T> {
    private Node<T> front;
    private Node<T> back;

    public Queue() {
        this.front = null;
        this.back = null;
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            front = newNode;
            back = newNode;
        } else {
            back.next = newNode;
            back = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = front.value;
        front = front.next;
        if (front == null) {
            back = null;
        }
        return value;
    }



    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.value;
    }

    public boolean isEmpty() {
        return front == null;
    }

}
