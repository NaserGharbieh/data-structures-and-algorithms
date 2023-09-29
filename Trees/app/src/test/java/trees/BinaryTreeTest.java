package trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {
    private BinaryTree<Integer> binaryTree;

    @BeforeEach
    public void setUp() {
        binaryTree = new BinaryTree<>();
        // Create a sample binary tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        binaryTree.root = new Node<>(1);
        binaryTree.root.left = new Node<>(2);
        binaryTree.root.right = new Node<>(3);
        binaryTree.root.left.left = new Node<>(4);
        binaryTree.root.left.right = new Node<>(5);
    }

    @Test
    public void testPreOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        binaryTree.preOrderTraversal(result);
        List<Integer> expected = List.of(1, 2, 4, 5, 3);
        assertEquals(expected, result);
    }

    @Test
    public void testInOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        binaryTree.inOrderTraversal(result);
        List<Integer> expected = List.of(4, 2, 5, 1, 3);
        assertEquals(expected, result);
    }

    @Test
    public void testPostOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        binaryTree.postOrderTraversal(result);
        List<Integer> expected = List.of(4, 5, 2, 3, 1);
        assertEquals(expected, result);
    }

    @Test
    public void testFindMaximumValue(){
      int result= binaryTree.findMaximumValue();
      int expected =5;
      assertEquals(expected,result);
    }

    @Test
    public void testBFS() {

        // Perform BFS and get the result
        List<Integer> result = BinaryTree.bfs(binaryTree);

        // Define your expected result
        List<Integer> expected = List.of(1, 2, 3, 4, 5);

        assertEquals(expected, result);
    }
}




