package Lecture14Test;

import Lecture14.QuickDisjointSet.QDSets;
import org.junit.Assert;
import org.junit.Test;

public class QDSetTest {

    @Test
    public void findInitialStateTest() {
        QDSets dsu = new QDSets(5);
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(i, dsu.find(i));
        }
    }

    @Test
    public void unionOperationTest() {
        QDSets dsu = new QDSets(5);
        dsu.union(0, 1);
        dsu.union(3, 4);
        Assert.assertEquals(dsu.find(0), dsu.find(1));
        Assert.assertEquals(dsu.find(3), dsu.find(4));
        Assert.assertNotEquals(dsu.find(2), dsu.find(0));
    }

    @Test
    public void multipleUnionsTest() {
        QDSets dsu = new QDSets(5);
        dsu.union(0, 1);
        dsu.union(3, 4);
        dsu.union(1, 4);
        int root0 = dsu.find(0);
        int root3 = dsu.find(3);
        Assert.assertEquals(root0, root3);
    }

    @Test
    public void addElemTest() {
        QDSets dsu = new QDSets(5);
        dsu.addElem();
        int newIdx = 5;
        Assert.assertEquals(newIdx, dsu.find(newIdx));
        dsu.union(0, newIdx);
        Assert.assertEquals(dsu.find(newIdx), dsu.find(0));
    }

    @Test
    public void resetTest() {
        QDSets dsu = new QDSets(5);
        dsu.union(0, 1);
        dsu.union(3, 4);
        dsu.addElem();
        dsu.union(0, 5);
        dsu.reset();
        for (int i = 0; i <= 5; i++) {
            Assert.assertEquals(i, dsu.find(i));
        }
    }
}