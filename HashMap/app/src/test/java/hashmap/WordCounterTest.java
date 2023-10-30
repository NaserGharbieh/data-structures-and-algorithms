package hashmap;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void testFirstRepeatedWord1() {
        String input = "Once upon a time, there was a brave princess who...";
        String result = WordCounter.repeatedWord(input);
        assertEquals("a", result);
    }

    @Test
    public void testFirstRepeatedWord2() {
        String input = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way – in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only...";
        String result = WordCounter.repeatedWord(input);
        assertEquals("it", result);
    }

    @Test
    public void testFirstRepeatedWord3() {
        String input = "It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York...";
        String result = WordCounter.repeatedWord(input);
        assertEquals("summer", result);
    }
}
