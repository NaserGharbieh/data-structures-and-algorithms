/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package merge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void testReverseSorted() {
        int[] inputArray = {20, 18, 12, 8, 5, -2};
        int[] expectedArray = {-2, 5, 8, 12, 18, 20};
        App.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testFewUniques() {
        int[] inputArray = {5, 12, 7, 5, 5, 7};
        int[] expectedArray = {5, 5, 5, 7, 7, 12};
        App.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }

    @Test
    void testNearlySorted() {
        int[] inputArray = {2, 3, 5, 7, 13, 11};
        int[] expectedArray = {2, 3, 5, 7, 11, 13};
        App.mergeSort(inputArray);
        assertArrayEquals(expectedArray, inputArray);
    }
}
