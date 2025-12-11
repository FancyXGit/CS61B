package Lecture17Test;

import Lecture17.BST.BST1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BSTTest {

    @Test
    void testAddAndFind() {
        BST1<Integer> bst = new BST1<>();
        bst.add(10);
        bst.add(5);
        bst.add(15);

        assertNotNull(bst.find(10));
        assertNotNull(bst.find(5));
        assertNotNull(bst.find(15));
        assertNull(bst.find(20));

        bst.printTree();
    }

    @Test
    void testFindMinAndMax() {
        BST1<Integer> bst = new BST1<>();
        bst.add(8);
        bst.add(3);
        bst.add(10);
        bst.add(1);
        bst.add(6);

        assertEquals(1, bst.findMin().getValue());
        assertEquals(10, bst.findMax().getValue());

        bst.printTree();
    }

    @Test
    void testDeleteLeaf() {
        BST1<Integer> bst = new BST1<>();
        bst.add(7);
        bst.add(3);
        bst.add(9);

        bst.delete(3);
        assertNull(bst.find(3));
        assertNotNull(bst.find(7));
        assertNotNull(bst.find(9));

        bst.printTree();
    }

    @Test
    void testDeleteNodeWithOneChild() {
        BST1<Integer> bst = new BST1<>();
        bst.add(7);
        bst.add(3);
        bst.add(9);
        bst.add(8);

        bst.delete(9);
        assertNull(bst.find(9));
        assertNotNull(bst.find(8));

        bst.printTree();
    }

    @Test
    void testDeleteNodeWithTwoChildren() {
        BST1<Integer> bst = new BST1<>();
        bst.add(7);
        bst.add(3);
        bst.add(9);
        bst.add(8);
        bst.add(10);

        bst.delete(9);
        assertNull(bst.find(9));
        assertNotNull(bst.find(8));
        assertNotNull(bst.find(10));

        bst.printTree();
    }
}
