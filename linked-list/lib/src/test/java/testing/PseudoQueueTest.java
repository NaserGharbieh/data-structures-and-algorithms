package testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue.PseudoQueue;

public class PseudoQueueTest {

    private PseudoQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new PseudoQueue<>();
    }

    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpity());
    }

    @Test
    public void testPeek() {
        queue.enqueue(42);
        queue.enqueue(17);

        assertEquals(42, queue.peek());
        assertEquals(42, queue.peek()); // Peek should not remove the element
        assertFalse(queue.isEmpity());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpity());

        queue.enqueue(5);
        assertFalse(queue.isEmpity());

        queue.dequeue();
        assertTrue(queue.isEmpity());
    }

    @Test
    public void testEnqueueAndDequeueMixed() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        queue.enqueue(3);
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpity());
    }


    }

