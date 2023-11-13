## Code Challenge 32.
### Find common values in 2 binary trees.
## Whiteboard Process


## Approach & Efficiency
### Algorithm:

1. We traverse the first binary tree and insert each node's value into a `HashMap`, with the value as the key. This step takes O(N1) time and space, where N1 is the number of nodes in the first tree.

2. We then traverse the second binary tree and, for each node:
   - Check if the value exists in the `HashMap` from the first tree. This check takes O(1) time on average for each value.
   - If it does, we mark it as a common value or store it in a list. This step takes O(N2) time, where N2 is the number of nodes in the second tree.

3. Finally, we return the list of common values, which takes O(N2) space for storing the list of common values.

### Time Complexity: O(N1 + N2)
- The time complexity of this algorithm is determined by the sum of the time it takes to traverse both trees, which is O(N1 + N2).

### Space Complexity: O(N1)
- The space complexity is determined by the space needed to store the values from the first tree in the `HashMap`, which is O(N1) as it stores each unique value from the first tree.

So, the time complexity is linear in terms of the total number of nodes in both trees, and the space complexity is linear in terms of the number of nodes in the first tree.
### Time Complexity:

 Space Complexity:


In summary, the `repeatedWord` method is designed to find the first repeated word in a string and has a time complexity of O(n) and a space complexity of O(m), where 'n' is the length of the input string and 'm' is the number of unique words in the string.:

## Solution
``` java 
public class TreeNode {

   public int val;
   public TreeNode left;
   public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
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

``` 
# Tests
``` java
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

```