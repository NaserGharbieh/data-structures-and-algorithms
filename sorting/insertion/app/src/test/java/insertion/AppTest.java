package insertion;

import insertion.App;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AppTest {
    @Test
    void testReverseSorted() {
        int[] inputArray = {20, 18, 12, 8, 5, -2};
        int[] expectedArray = {-2, 5, 8, 12, 18, 20};
        App.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testFewUniques() {
        int[] inputArray = {5, 12, 7, 5, 5, 7};
        int[] expectedArray = {5, 5, 5, 7, 7, 12};
        App.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testNearlySorted() {
        int[] inputArray = {2, 3, 5, 7, 13, 11};
        int[] expectedArray = {2, 3, 5, 7, 11, 13};
        App.insertionSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }
}
