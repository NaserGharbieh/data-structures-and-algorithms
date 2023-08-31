package testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import stack.Stack;

class StackTest {

    @Test
    void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);

        assertFalse(stack.isEmpty());
        assertEquals(5, stack.peek());
    }

    @Test
    void testPushMultipleValues() {
        Stack<String> stack = new Stack<>();
        stack.push("apple");
        stack.push("banana");
        stack.push("cherry");

        assertFalse(stack.isEmpty());
        assertEquals("cherry", stack.peek());
    }

    @Test
    void testPop() {
        Stack<Double> stack = new Stack<>();
        stack.push(3.14);
        double poppedValue = stack.pop();

        assertTrue(stack.isEmpty());
        assertEquals(3.14, poppedValue);
    }

    @Test
    void testEmptyStackAfterMultiplePops() {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.pop();
        stack.pop();
        stack.pop();

        assertTrue(stack.isEmpty());
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void testPeek() {
        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals("three", stack.peek());
        assertFalse(stack.isEmpty());
    }

    @Test
    void testInstantiateEmptyStack() {
        Stack<Integer> stack = new Stack<>();

        assertTrue(stack.isEmpty());
    }
}

