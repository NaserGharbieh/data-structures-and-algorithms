package linked.list;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;







public class LinkedListTest {

    @Test
    void testInsertAndToString() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(30);
        linkedList.insert(99);
        linkedList.insert(10);

        assertEquals("10 -> 99 -> 30 -> NULL", linkedList.toString());
    }
    @Test
    void testInsertAndToStringIfLinkedListIsEmpity () {
        LinkedList linkedList = new LinkedList();
        assertEquals("linked list is empty!!", linkedList.toString());

    }

    @Test
    void testIncludes() {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(2000);
        linkedList.insert(152);
        linkedList.insert(10);

        assertTrue(linkedList.Includes(10));
        assertFalse(linkedList.Includes(1611));
    }
}