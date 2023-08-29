package linked.list;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;







public class LinkedListTest {

    @Test
    void testInsertAndToString() {
        LinkedList LinkedList = new LinkedList();
        LinkedList.insert(30);
        LinkedList.insert(99);
        LinkedList.insert(10);

        assertEquals("10 -> 99 -> 30 -> NULL", LinkedList.toString());
    }

    @Test
    void testInsertAndToStringIfLinkedListIsEmpity() {
        LinkedList LinkedList = new LinkedList();
        assertEquals("linked list is empty!!", LinkedList.toString());

    }

    @Test
    void testIncludes() {
        LinkedList LinkedList = new LinkedList();
        LinkedList.insert(2000);
        LinkedList.insert(152);
        LinkedList.insert(10);

        assertTrue(LinkedList.Includes(10));
        assertFalse(LinkedList.Includes(1611));
    }

    @Test
    void testAppendAndToString() {
        LinkedList list = new LinkedList();
        list.append(5);
        list.append(10);
        list.append(15);

        assertEquals("5 -> 10 -> 15 -> NULL", list.toString());
    }

    @Test
    void testInsertBeforeAndToString() {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insertBefore(10, 12);


        assertEquals("15 -> 12 -> 10 -> 5 -> NULL", list.toString());
    }

    @Test
    void testInsertAfterAndToString() {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(15);
        list.insertAfter(10, 12);

        assertEquals("15 -> 10 -> 12 -> 5 -> NULL", list.toString());
    }

    @Test
    void testKthFromEndWhereKGreaterThanListLength() {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(15);

        assertThrows(IllegalArgumentException.class, () -> list.kthFromEnd(5));
    }

    @Test
    void testKthFromEndWhereKAndListLengthAreSame() {
        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(15);

        assertThrows(IllegalArgumentException.class, () -> list.kthFromEnd(3));
    }

    @Test
    void testKthFromEndWhereKNegative() {

        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(15);

        assertThrows(IllegalArgumentException.class, () -> list.kthFromEnd(-2));
    }

    @Test
    void testKthFromEndWhereListSizeIs1() {
        LinkedList list = new LinkedList();
        list.insert(5);

        assertEquals(5, list.kthFromEnd(0));
    }

    @Test
    void testKthFromEndHappyPath() {

        LinkedList list = new LinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(15);

        assertEquals(10, list.kthFromEnd(1));
    }

    @Test
    void testZipLists() {
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);

        LinkedList list2 = new LinkedList();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);

        LinkedList result = new LinkedList();
        result = result.zipLists(list1, list2);

        assertEquals("5 -> 6 -> 3 -> 4 -> 1 -> 2 -> NULL", result.toString());
    }




}