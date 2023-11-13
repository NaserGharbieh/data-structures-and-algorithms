package TreeIntersection;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeIntersection {
    public static List<Integer> findCommonValues(TreeNode root1, TreeNode root2) {
        // Create a HashMap to store values from the first tree
        HashMap<Integer, Boolean> valuesMap = new HashMap<>();
        // Create a list to store common values
        List<Integer> commonValues = new ArrayList<>();

        // Traverse the first tree and insert values into the HashMap
        traverseAndInsert(root1, valuesMap);

        // Traverse the second tree and check for common values
        traverseAndCheck(root2, valuesMap, commonValues);

        return commonValues;
    }

    private static void traverseAndInsert(TreeNode node, HashMap<Integer, Boolean> valuesMap) {
        if (node == null) {
            return;
        }

        // Insert the value into the HashMap
        valuesMap.put(node.val, true);

        // Recursively traverse left and right subtrees
        traverseAndInsert(node.left, valuesMap);
        traverseAndInsert(node.right, valuesMap);
    }

    private static void traverseAndCheck(TreeNode node, HashMap<Integer, Boolean> valuesMap, List<Integer> commonValues) {
        if (node == null) {
            return;
        }

        // Check if the value exists in the HashMap
        if (valuesMap.containsKey(node.val)) {
            commonValues.add(node.val);
        }

        // Recursively traverse left and right subtrees
        traverseAndCheck(node.left, valuesMap, commonValues);
        traverseAndCheck(node.right, valuesMap, commonValues);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);

        List<Integer> commonValues = findCommonValues(root1, root2);
        System.out.println("Common Values: " + commonValues);
    }
}
