package hashmap;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WordCounter {
    public static String repeatedWord(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        HashMap<String, Integer> wordCount = new HashMap<>(16);
        String[] words = input.toLowerCase().split("\\W+");

        for (String word : words) {
            if (wordCount.has(word)) {
                return word;
            } else {
                wordCount.set(word, 1);
            }
        }

        return null; // No repeated words found
    }

    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog. The quick brown fox is fast.";
        String result = repeatedWord(input);
        System.out.println("First repeated word: " + result); // Output: "the"
    }
}
