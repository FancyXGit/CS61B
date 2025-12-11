package Lecture14.QuickDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class QDSets {
    private List<Integer> parent;
    private int size;

    public QDSets(int s) {
        this.size = s;
        parent = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            parent.add(-1);
        }
    }

    public int find(int idx) {
        if (parent.get(idx) < 0) {
            return idx;
        }
        int root = find(parent.get(idx));
        parent.set(idx, root);
        return root;
    }

    public void union(int idx1, int idx2) {
        int root1 = find(idx1);
        int root2 = find(idx2);

        int rootVal1 = parent.get(root1);
        int rootVal2 = parent.get(root2);

        if (root1 == root2) {
            return;
        }

        if (Math.abs(rootVal1) < Math.abs(rootVal2)) {
            parent.set(root1, root2);
            parent.set(root2, rootVal1 + rootVal2);
        } else {
            parent.set(root2, root1);
            parent.set(root1, rootVal1 + rootVal2);
        }
    }

    public boolean isConnected(int idx1, int idx2) {
        return find(idx1) == find(idx2);
    }

    public void addElem() {
        parent.add(-1);
        size++;
    }

    public int getSize() {
        return size;
    }

    public void reset() {
        for (int i = 0; i < size; i++) {
            parent.set(i, -1);
        }
    }
}
