package trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> binarySearchTree;

    @BeforeEach
    public void setUp() {
        binarySearchTree = new BinarySearchTree<>();
        // Create a sample binary search tree:
        //       3
        //      / \
        //     1   5
        //    / \
        //   0   2
        binarySearchTree.add(3);
        binarySearchTree.add(1);
        binarySearchTree.add(5);
        binarySearchTree.add(0);
        binarySearchTree.add(2);
    }

    @Test
    public void testContains() {
        assertTrue(binarySearchTree.Contains(3));
        assertTrue(binarySearchTree.Contains(0));
        assertTrue(binarySearchTree.Contains(5));
        assertFalse(binarySearchTree.Contains(4));
    }

    @Test
    public void testAdd() {
        assertFalse(binarySearchTree.Contains(4));
        binarySearchTree.add(4);
        assertTrue(binarySearchTree.Contains(4));
    }

    @Test
    public void testAddExistingValue() {
        assertTrue(binarySearchTree.Contains(2));
        // Adding an existing value should not change the tree
        binarySearchTree.add(2);
        assertTrue(binarySearchTree.Contains(2));
    }
}
