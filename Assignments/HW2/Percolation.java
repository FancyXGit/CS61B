import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private boolean[] sites;
    private WeightedQuickUnionUF unionUF;      // used for percolation checks (has virtual top and bottom)
    private WeightedQuickUnionUF unionUFFull;  // used to check fullness (only virtual top)
    private int size;
    private int openSitesCount;
    private int virtualUpperNode;
    private int virtualLowerNode;

    public Percolation(int N) {
        if (N <= 0){
            throw new IllegalArgumentException();
        }
        sites = new boolean[N * N];
        unionUF = new WeightedQuickUnionUF(N * N + 2);
        unionUFFull = new WeightedQuickUnionUF(N * N + 1);
        size = N;
        virtualUpperNode = N * N;
        virtualLowerNode = N * N + 1;
    }

    public void open(int row, int col) {
        if (!isLegalLocation(row, col)){
            throw new IndexOutOfBoundsException();
        }
        int idx = xy2OneD(row, col);
        if (!sites[idx]) {
            sites[idx] = true;
            openSitesCount++;

            if (row == 0) {
                unionUF.union(idx, virtualUpperNode);
                unionUFFull.union(idx, virtualUpperNode);
            }
            if (row == size - 1) {
                unionUF.union(idx, virtualLowerNode);
            }

            if (row - 1 >= 0 && isOpen(row - 1, col)){
                int nIdx = xy2OneD(row - 1, col);
                unionUF.union(nIdx, idx);
                unionUFFull.union(nIdx, idx);
            }
            if (row + 1 <= size - 1 && isOpen(row + 1, col)){
                int nIdx = xy2OneD(row + 1, col);
                unionUF.union(nIdx, idx);
                unionUFFull.union(nIdx, idx);
            }
            if (col - 1 >= 0 && isOpen(row, col - 1)){
                int nIdx = xy2OneD(row, col - 1);
                unionUF.union(nIdx, idx);
                unionUFFull.union(nIdx, idx);
            }
            if (col + 1 <= size - 1 && isOpen(row, col + 1)){
                int nIdx = xy2OneD(row, col + 1);
                unionUF.union(nIdx, idx);
                unionUFFull.union(nIdx, idx);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        if (!isLegalLocation(row, col)){
            throw new IndexOutOfBoundsException();
        }
        return sites[xy2OneD(row, col)];
    }

    public boolean isFull(int row, int col) {
        if (!isLegalLocation(row, col)){
            throw new IndexOutOfBoundsException();
        }
        if (!isOpen(row, col)){
            return false;
        }
        return unionUFFull.connected(xy2OneD(row, col), virtualUpperNode);
    }

    public int numberOfOpenSites() {
        return openSitesCount;
    }

    public boolean percolates() {
        return unionUF.connected(virtualUpperNode, virtualLowerNode);
    }

    private int xy2OneD(int x, int y){
        return x * this.size + y;
    }

    private boolean isLegalLocation(int x, int y){
        return (x >= 0 && x < size) && (y >= 0 && y < size);
    }
}
