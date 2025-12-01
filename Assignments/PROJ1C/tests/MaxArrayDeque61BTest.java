import deque.MaxArrayDeque61B;
import org.junit.jupiter.api.*;

import java.util.Comparator;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class MaxArrayDeque61BTest {
    private static class StringLengthComparator implements Comparator<String> {
        public int compare(String a, String b) {
            return a.length() - b.length();
        }
    }

    private static class StringLexComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    }

    @Test
    public void basicTest() {
        MaxArrayDeque61B<String> mad = new MaxArrayDeque61B<>(new StringLengthComparator());
        mad.addFirst("");
        mad.addFirst("2");
        mad.addFirst("fury road");
        assertThat(mad.max()).isEqualTo("fury road");
    }

    @Test
    public void testLengthComparator() {
        MaxArrayDeque61B<String> mad = new MaxArrayDeque61B<>(new StringLengthComparator());
        mad.addLast("hi");
        mad.addLast("hello");
        mad.addLast("!");
        assertThat(mad.max()).isEqualTo("hello");
    }

    @Test
    public void testLexComparator() {
        MaxArrayDeque61B<String> mad = new MaxArrayDeque61B<>(new StringLengthComparator());
        mad.addLast("hi");
        mad.addLast("hello");
        mad.addLast("!");
        // 用字典序比较器
        assertThat(mad.max(new StringLexComparator())).isEqualTo("hi");
    }

    @Test
    public void testIntegerComparator() {
        Comparator<Integer> cmp = Integer::compareTo;
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<>(cmp);
        mad.addLast(3);
        mad.addLast(7);
        mad.addLast(2);
        assertThat(mad.max()).isEqualTo(7);
    }
}
