import deque.LinkedListDeque61B;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

public class LinkedListDeque61BTest {

    @Test
    public void testIterator() {
        LinkedListDeque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        Iterator<Integer> it = deque.iterator();
        assertTrue(it.hasNext());
        assertEquals(Integer.valueOf(1), it.next());
        assertEquals(Integer.valueOf(2), it.next());
        assertEquals(Integer.valueOf(3), it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testEquals() {
        LinkedListDeque61B<Integer> deque1 = new LinkedListDeque61B<>();
        LinkedListDeque61B<Integer> deque2 = new LinkedListDeque61B<>();
        for (int i = 0; i < 3; i++) {
            deque1.addLast(i);
            deque2.addLast(i);
        }
        assertEquals(deque1, deque2);
        deque2.addLast(4);
        assertNotEquals(deque1, deque2);
    }

    @Test
    public void testToString() {
        LinkedListDeque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        String str = deque.toString();
        assertEquals("[10, 20, 30]", str);
    }
}

