package queue;

public class Queue<T> {
    private Node<T> front;

    public Queue() {
        this.front = null;
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            front = newNode;
        } else {
            Node<T> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = front.value;
        front = front.next;
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
