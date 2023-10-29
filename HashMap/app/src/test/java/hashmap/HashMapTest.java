package hashmap;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    private HashMap<String, Integer> hashMap;

    @BeforeEach
    public void setUp() {
        hashMap = new HashMap<>(16); // Create a new HashMap before each test
    }

    @Test
    public void testSetAndGet() {
        hashMap.set("key1", 42);
        assertEquals(42, hashMap.get("key1"));
    }

    @Test
    public void testNullValue() {
        hashMap.set("key1", null);
        assertNull(hashMap.get("key1"));
    }

    @Test
    public void testNonExistentKey() {
        assertNull(hashMap.get("nonexistentKey"));
    }

    @Test
    public void testUniqueKeys() {
        hashMap.set("key1", 1);
        hashMap.set("key2", 2);
        hashMap.set("key3", 3);
        assertEquals(3, hashMap.keys().size());
    }

    @Test
    public void testCollisionHandling() {
        // Two different keys hash to the same bucket
        hashMap.set("key1", 1);
        hashMap.set("key2", 2);
        assertEquals(1, hashMap.get("key1"));
        assertEquals(2, hashMap.get("key2"));
    }

    @Test
    public void testBucketCollisionHandling() {
        // Two key-value pairs collide in the same bucket
        hashMap.set("key1", 1);
        hashMap.set("key17", 17);
        assertEquals(1, hashMap.get("key1"));
        assertEquals(17, hashMap.get("key17"));
    }

    @Test
    public void testHashInRange() {
        int hash = hashMap.hash("key1");
        assertTrue(hash >= 0 && hash < 16); // Assuming a capacity of 16
    }
}
