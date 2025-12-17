import java.util.ArrayList;
import java.util.List;

public class UnionFind {

    private List<Integer> data;

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        data = new ArrayList<>();
        for (int i = 0; i < N; i++){
            data.add(-1);
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        int root = this.find(v);
        return -data.get(root);
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        return data.get(v);
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        return this.find(v1) == this.find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        if (v < 0 || v >= data.size()){
            throw new IllegalArgumentException("Illegal Argument v.");
        }
        if (this.parent(v) < 0){
            return v;
        }
        int root = find(this.parent(v));
        data.set(v, root);
        return root;
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        int root1 = this.find(v1);
        int root2 = this.find(v2);
        if (root1 == root2){
            return;
        }
        int size1 = -data.get(root1);
        int size2 = -data.get(root2);
        if (size1 <= size2){
            data.set(root2, data.get(root2) + data.get(root1));
            data.set(root1, root2);
        } else {
            data.set(root1, data.get(root1) + data.get(root2));
            data.set(root2, root1);
        }
    }

}
