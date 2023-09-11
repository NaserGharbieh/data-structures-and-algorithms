## Code Challenge 10: Queue-Implmentation
### Implment a Queue data structure class 
## Whiteboard Process
![CC10-stack](whiteboards/CC10-Queue-Implmentation.png)

## Approach & Efficiency
## there are 2 main methods 
### 1. enqueue(T value) : method inserts a new element (node) at the back (or rear) of the queue.
- **Algorithm :**
1. Create a new node `newNode` with the given `value`.
2. If the queue is empty (both front and rear references are null), set
   both the front and rear references to the new node.
3. If the queue is not empty, set the next reference of the current back
   node to the new node, and then update the back reference to point to
   the new node.
   
- **Time Complexity:** O(1)
    - The `enqueue` method inserts a new element (node) at the back (or rear) of the queue.
    - Regardless of the number of elements currently in the queue, the `enqueue` operation takes a constant amount of time because it involves creating a new node, setting its `next` reference to the current back node, and updating the `back` reference to the new node.
    - The time complexity is not dependent on the size of the queue.
  

- **Space Complexity:** O(1)
    - The `enqueue` method uses a constant amount of additional memory regardless of the size of the queue.
    - It creates a single new node for the element being enqueued, and the memory usage does not depend on the number of elements already in the queue.
    - The space complexity is constant.

### 2. dequeue() : removes and returns the element from the front of the queue.
- **Algorithm :**
1. Check if the queue is empty by inspecting the `front` reference. If it's `null`, the
   queue is empty, and you cannot dequeue.
2. If the queue is not empty, retrieve the value stored in the front node.
3. Update the `front` reference to point to the next node in the queue.
4. Check if the queue has become empty after dequeuing. If `front` is `null`, update the `back` reference to `null` as well (since there are no elements left).

- **Time Complexity:** O(1)
    - The `dequeue` method removes and returns the element from the front of the queue.
    - Regardless of the number of elements currently in the queue, the `dequeue` operation takes a constant amount of time because it involves updating the `front` reference to point to the next node.
    - The time complexity is not dependent on the size of the queue.


- **Space Complexity:** O(1)
    - The `dequeue` method uses a constant amount of additional memory regardless of the size of the queue.
    - It does not create new data structures or allocate additional memory that scales with the number of elements in the queue.
    - The space complexity is constant.

## Solution
``` java 
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

``` 
# Tests
``` java
class QueueTest {

    @Test
    void testEnqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(5);

        assertFalse(queue.isEmpty());
        assertEquals(5, queue.peek());
    }

    @Test
    void testEnqueueMultipleValues() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("apple");
        queue.enqueue("banana");
        queue.enqueue("cherry");

        assertFalse(queue.isEmpty());
        assertEquals("apple", queue.peek());
    }

    @Test
    void testDequeue() {
        Queue<Double> queue = new Queue<>();
        queue.enqueue(3.14);
        double dequeuedValue = queue.dequeue();

        assertTrue(queue.isEmpty());
        assertEquals(3.14, dequeuedValue);
    }

    @Test
    void testPeek() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");

        assertEquals("one", queue.peek());
        assertFalse(queue.isEmpty());
    }

    @Test
    void testEmptyQueueAfterMultipleDequeues() {
        Queue<Character> queue = new Queue<>();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        assertTrue(queue.isEmpty());
        assertThrows(IllegalStateException.class, queue::dequeue);
        assertThrows(IllegalStateException.class, queue::peek);
    }

    @Test
    void testInstantiateEmptyQueue() {
        Queue<Integer> queue = new Queue<>();

        assertTrue(queue.isEmpty());
        assertThrows(IllegalStateException.class, queue::dequeue);
        assertThrows(IllegalStateException.class, queue::peek);
    }
}


```