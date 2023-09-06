package testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue.Animal;
import queue.AnimalShelter;


public class AnimalShelterTest {

    private AnimalShelter shelter;


    @BeforeEach
    public void setUp() {
        shelter = new AnimalShelter();
    }

    @Test
    public void testEnqueueAndDequeueCat() {
        Animal cat1 = new Animal("cat", "Whiskers");
        Animal cat2 = new Animal("cat", "Mittens");
        Animal dog1 = new Animal("dog", "Fido");

        shelter.enqueue(cat1);
        shelter.enqueue(cat2);
        shelter.enqueue(dog1);

        assertEquals("Whiskers", shelter.dequeue("cat").getName());
        assertEquals("Mittens", shelter.dequeue("cat").getName());
    }

    @Test
    public void testEnqueueAndDequeueDog() {
        Animal cat1 = new Animal("cat", "Fluffy");
        Animal dog1 = new Animal("dog", "Rex");
        Animal dog2 = new Animal("dog", "Buddy");

        shelter.enqueue(cat1);
        shelter.enqueue(dog1);
        shelter.enqueue(dog2);

        assertEquals("Rex", shelter.dequeue("dog").getName());
        assertEquals("Buddy", shelter.dequeue("dog").getName());
    }

    @Test
    public void testDequeueEmptyShelter() {
        assertNull(shelter.dequeue("cat"));
        assertNull(shelter.dequeue("dog"));
    }
}

