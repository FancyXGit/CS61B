import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ArrayDeque61BTest {

    @Test
    public void DequeToListTest(){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addFirst(0);
        List<Integer> list = deque.toList();
        assertThat(list).containsExactly(0, 1, 2, 3).inOrder();
    }

    @Test
    public void DequeAddFirstTest(){
        ArrayDeque61B<String> deque = new ArrayDeque61B<>();
        deque.addFirst("b");
        deque.addFirst("a");
        List<String> list = deque.toList();
        assertThat(list).containsExactly("a", "b").inOrder();
    }

    @Test
    public void DequeAddLastTest(){
        ArrayDeque61B<String> deque = new ArrayDeque61B<>();
        deque.addLast("a");
        deque.addLast("b");
        List<String> list = deque.toList();
        assertThat(list).containsExactly("a", "b").inOrder();
    }

    @Test
    public void DequeIsEmptyTest(){
        ArrayDeque61B<Double> deque = new ArrayDeque61B<>();
        assertThat(deque.isEmpty()).isTrue();
        deque.addLast(1.1);
        assertThat(deque.isEmpty()).isFalse();
    }

    @Test
    public void DequeAddFirstAndRemoveIsEmptyTest(){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        deque.addFirst(10);
        assertThat(deque.isEmpty()).isFalse();
        deque.removeFirst();
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    public void DequeSizeTest(){
        ArrayDeque61B<Character> deque = new ArrayDeque61B<>();
        assertThat(deque.size()).isEqualTo(0);
        deque.addLast('a');
        deque.addFirst('b');
        assertThat(deque.size()).isEqualTo(2);
        deque.removeFirst();
        assertThat(deque.size()).isEqualTo(1);
    }

    @Test
    public void DequeRemoveFirstTest(){
        ArrayDeque61B<String> deque = new ArrayDeque61B<>();

        deque.removeFirst();
        assertThat(deque.isEmpty()).isTrue();

        deque.addLast("first");
        deque.addLast("second");
        String removed = deque.removeFirst();

        assertThat(removed).isEqualTo("first");

        List<String> list = deque.toList();
        assertThat(list).containsExactly("second").inOrder();
    }

    @Test
    public void DequeRemoveLastTest(){
        ArrayDeque61B<String> deque = new ArrayDeque61B<>();

        deque.removeLast();
        assertThat(deque.isEmpty()).isTrue();

        deque.addLast("first");
        deque.addLast("second");
        String removed = deque.removeLast();

        assertThat(removed).isEqualTo("second");

        List<String> list = deque.toList();
        assertThat(list).containsExactly("first").inOrder();
    }

    @Test
    public void DequeRemoveUntilEmptyTest(){
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        for (int i = 0; i < 5; i++){
            deque.addLast(i);
        }
        for (int i = 0; i < 5; i++){
            deque.removeFirst();
        }
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    public void DequeGetItemTest(){
        ArrayDeque61B<String> deque = new ArrayDeque61B<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");

        assertThat(deque.get(0)).isEqualTo("a");
        assertThat(deque.get(1)).isEqualTo("b");
        assertThat(deque.get(2)).isEqualTo("c");
        assertThat(deque.get(3)).isNull();
    }

    @Test
    public void DequeGetItemRecursiveTest(){
        ArrayDeque61B<String> deque = new ArrayDeque61B<>();
        deque.addLast("x");
        deque.addLast("y");
        deque.addLast("z");

        assertThat(deque.getRecursive(0)).isEqualTo("x");
        assertThat(deque.getRecursive(1)).isEqualTo("y");
        assertThat(deque.getRecursive(2)).isEqualTo("z");
        assertThat(deque.getRecursive(3)).isNull();
    }

    @Test
    public void DequeResizeExpansionTest() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        int initialCapacity = deque.ONLY_FOR_TESTING_getCapacity();
        // 填满初始容量并触发扩容
        for (int i = 0; i < initialCapacity; i++) {
            deque.addLast(i);
        }
        // 此时应扩容
        deque.addLast(100);
        int expandedCapacity = deque.ONLY_FOR_TESTING_getCapacity();
        assertThat(expandedCapacity).isGreaterThan(initialCapacity);
        // 检查数据顺序
        for (int i = 0; i < initialCapacity; i++) {
            assertThat(deque.get(i)).isEqualTo(i);
        }
        assertThat(deque.get(initialCapacity)).isEqualTo(100);
    }

    @Test
    public void DequeResizeShrinkTest() {
        ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
        int initialCapacity = deque.ONLY_FOR_TESTING_getCapacity();
        // 先扩容
        for (int i = 0; i < initialCapacity * 2; i++) {
            deque.addLast(i);
        }
        int expandedCapacity = deque.ONLY_FOR_TESTING_getCapacity();
        assertThat(expandedCapacity).isGreaterThan(initialCapacity);
        // 移除大部分元素，触发缩容
        for (int i = 0; i < initialCapacity * 2 - 2; i++) {
            deque.removeFirst();
        }
        int shrunkenCapacity = deque.ONLY_FOR_TESTING_getCapacity();
        assertThat(shrunkenCapacity).isLessThan(expandedCapacity);
        assertThat(shrunkenCapacity).isAtLeast(initialCapacity);
    }

}
