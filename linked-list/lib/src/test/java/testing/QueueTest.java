package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import queue.Queue;

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

