package hashmap;

import TreeIntersection.TreeNode;
import TreeIntersection.TreeIntersection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeIntersectionTest {

    @Test
    public void testFindCommonValues() {
        // Create the first binary tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        // Create the second binary tree
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(7);


        List<Integer> commonValues = TreeIntersection.findCommonValues(root1, root2);

        // Expected common values: [3, 4]
        assertEquals(2, commonValues.size());
        assertEquals(true, commonValues.contains(3));
        assertEquals(true, commonValues.contains(4));
    }

    @Test
    public void testFindCommonValuesNoCommonValues() {
        // Create the first binary tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        // Create the second binary tree
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(6);

        List<Integer> commonValues = TreeIntersection.findCommonValues(root1, root2);

        // Expected common values: an empty list
        assertEquals(0, commonValues.size());
    }
}

