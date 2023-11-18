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

    public static void main(String[] args) {
        // Example usage
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

        List<List<String>> result = leftJoin(synonyms, antonyms);

        // Print the result
        for (List<String> row : result) {
            System.out.println(row);
        }
    }
}

