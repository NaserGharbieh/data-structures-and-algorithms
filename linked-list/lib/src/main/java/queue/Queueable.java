package queue;

public interface Queueable <T> {
    void enqueue(T value);
    T dequeue();
    T peek();

}
