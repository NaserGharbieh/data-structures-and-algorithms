package trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 public class FizzBuzzTreeTest {

    @Test
    public void testFizzBuzzTree() {
        TreeNode node1 = new TreeNode("3");
        TreeNode node2 = new TreeNode("5");
        TreeNode node3 = new TreeNode("15");
        TreeNode node4 = new TreeNode("7");

        node1.children.add(node2);
        node1.children.add(node3);
        node1.children.add(node4);
        FizzBuzzTree fizzBuzzTree = new FizzBuzzTree();
        TreeNode newRoot = fizzBuzzTree.fizzBuzzTree(node1);

        String expectedOutput = "Fizz BuzzFizzBuzz7";

        String actualOutput = treeToString(newRoot);

        assertEquals(expectedOutput, actualOutput);
    }
    private String treeToString(TreeNode root) {
        if (root == null) return "";
        StringBuilder result = new StringBuilder(root.val + " ");
        for (TreeNode child : root.children) {
            result.append(treeToString(child));
        }
        return result.toString().trim();
    }
}