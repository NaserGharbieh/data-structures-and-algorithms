## Code Challenge 33.
### Write a function that LEFT JOINs two hashmaps into a single data structure.



## Approach & Efficiency
The `leftJoin` method iterates over the entries of the `synonyms` HashMap, retrieves corresponding values from the `antonyms` HashMap, and creates a new list for each entry. The lists are then added to the result list. Here's a breakdown of the algorithm:

### Algorithm:
   1. Iterate over each entry in the `synonyms` HashMap.
   2. For each entry, retrieve the corresponding value from the `antonyms` HashMap.
   3. Create a new list containing the key, synonym value, and antonym value (or `null` if the antonym is not present).
   4. Add each new list to the result list.

### Time Complexity:
 - The time complexity is O(n), where n is the size of the `synonyms` HashMap.
 - This is because each entry is processed once.

### Space Complexity:
 - The space complexity is O(n), where n is the size of the `synonyms` HashMap.
 - This is due to the space required for the result list, which contains n lists (one for each entry).

## Solution
``` java 
package hashmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeftJoin {

    public static List<List<String>> leftJoin(
            HashMap<String, String> synonyms,
            HashMap<String, String> antonyms
    ) {
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, String> entry : synonyms.entrySet()) {
            List<String> row = new ArrayList<>();
            String key = entry.getKey();
            String synonymValue = entry.getValue();
            String antonymValue = antonyms.getOrDefault(key, null);

            row.add(key);
            row.add(synonymValue);
            row.add(antonymValue);

            result.add(row);
        }

        return result;
    }

``` 
# Tests
``` java
public class LeftJoinTest {

    @Test
    void testLeftJoin() {
        HashMap<String, String> synonyms = new HashMap<>();
        synonyms.put("diligent", "employed");
        synonyms.put("fond", "enamored");
        synonyms.put("guide", "usher");
        synonyms.put("outfit", "garb");
        synonyms.put("wrath", "anger");

        HashMap<String, String> antonyms = new HashMap<>();
        antonyms.put("diligent", "idle");
        antonyms.put("fond", "averse");
        antonyms.put("guide", "follow");
        antonyms.put("flow", "jam");
        antonyms.put("wrath", "delight");

        // When
        List<List<String>> result = LeftJoin.leftJoin(synonyms, antonyms);

        // Then
        assertTrue(result.contains(Arrays.asList("diligent", "employed", "idle")));
        assertTrue(result.contains(Arrays.asList("fond", "enamored", "averse")));
        assertTrue(result.contains(Arrays.asList("guide", "usher", "follow")));
        assertTrue(result.contains(Arrays.asList("outfit", "garb", null)));
        assertTrue(result.contains(Arrays.asList("wrath", "anger", "delight")));
    }

    @Test
    void testLeftJoinWithEmptyMaps() {
        HashMap<String, String> synonyms = new HashMap<>();
        HashMap<String, String> antonyms = new HashMap<>();

        List<List<String>> result = LeftJoin.leftJoin(synonyms, antonyms);

        assertEquals(0, result.size());
    }
}