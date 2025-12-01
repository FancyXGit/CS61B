import deque.ArrayDeque61B;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

public class ArrayDeque61BTest {
    @Test
    public void testIterator() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        Iterator<Integer> it = ad.iterator();
        assertTrue(it.hasNext());
        assertEquals((Integer) 1, it.next());
        assertEquals((Integer) 2, it.next());
        assertEquals((Integer) 3, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testEquals() {
        ArrayDeque61B<String> ad1 = new ArrayDeque61B<>();
        ArrayDeque61B<String> ad2 = new ArrayDeque61B<>();
        ad1.addLast("a");
        ad1.addLast("b");
        ad2.addLast("a");
        ad2.addLast("b");
        assertEquals(ad1, ad2);
        ad2.addLast("c");
        assertNotEquals(ad1, ad2);
    }

    @Test
    public void testToString() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        String s = ad.toString();
        // 假设toString格式为: [1, 2, 3]
        assertEquals("[1, 2, 3]", s);
    }
}

