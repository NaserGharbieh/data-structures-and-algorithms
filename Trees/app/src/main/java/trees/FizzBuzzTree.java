package trees;

import java.util.ArrayList;
import java.util.List;
class TreeNode {
    String val;
    List<TreeNode> children;

    public TreeNode(String val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class FizzBuzzTree {

    public TreeNode fizzBuzzTree(TreeNode root) {
        if (root == null) return null;

        TreeNode newRoot = new TreeNode(transformValue(root.val));

        for (TreeNode child : root.children) {
            newRoot.children.add(fizzBuzzTree(child));
        }

        return newRoot;
    }

    private String transformValue(String val) {
        int num = Integer.parseInt(val);

        if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        } else if (num % 3 == 0) {
            return "Fizz";
        } else if (num % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(num);
        }
    }    }