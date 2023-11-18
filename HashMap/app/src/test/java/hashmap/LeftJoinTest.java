package hashmap;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
