package trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {

    @Test
    public void testNodeCreation() {
        // Test creating a Node with an integer value
        Node<Integer> integerNode = new Node<>(42);
        assertEquals(42, integerNode.getValue());

        // Test creating a Node with a String value
        Node<String> stringNode = new Node<>("Hello, World!");
        assertEquals("Hello, World!", stringNode.getValue());
    }

    @Test
    public void testSettersAndGetters() {
        Node<Integer> node = new Node<>(10);

        // Test setting and getting the left child
        Node<Integer> leftChild = new Node<>(5);
        node.setLeft(leftChild);
        assertEquals(leftChild, node.getLeft());

        // Test setting and getting the right child
        Node<Integer> rightChild = new Node<>(15);
        node.setRight(rightChild);
        assertEquals(rightChild, node.getRight());

        // Test setting and getting the value
        node.setValue(20);
        assertEquals(20, node.getValue());
    }
}

