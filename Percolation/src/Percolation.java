import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final boolean[][] grid; // grid[i][j] = site at row i, column j
    private final int len; // length of the grid
    private final static int top = 0; // virtual top
    private final int bottom; // virtual bottom
    private final WeightedQuickUnionUF uf; // a WeightedQuickUnionUF instance
    private int count = 0;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        len = n;
        grid = new boolean[n][n];
        bottom = n * n + 1;
        uf = new WeightedQuickUnionUF(n * n + 2);
    }

    public void open(int i, int j) {
        if(i > len || j > len || i < 1 || j < 1) throw new IllegalArgumentException("exception");
        if (!isOpen(i, j)) {
            grid[i - 1][j - 1] = true;
            count++;
        }


        if (i == 1) { // union virtual top
            uf.union(getSiteIndex(i, j), top);
        }
        if (i == len) { // union virtual bottom
            uf.union(getSiteIndex(i, j), bottom);
        }

        // union possible neighbor(s)
        if (i > 1 && isOpen(i - 1, j)) {
            uf.union(getSiteIndex(i, j), getSiteIndex(i - 1, j));
        }
        if (i < len && isOpen(i + 1, j)) {
            uf.union(getSiteIndex(i, j), getSiteIndex(i + 1, j));
        }
        if (j > 1 && isOpen(i, j - 1)) {
            uf.union(getSiteIndex(i, j), getSiteIndex(i, j - 1));
        }
        if (j < len && isOpen(i, j + 1)) {
            uf.union(getSiteIndex(i, j), getSiteIndex(i, j + 1));
        }
    }

    public boolean isOpen(int i, int j) {
        if(i > len || j > len || i < 1 || j < 1) throw new IllegalArgumentException("exception");
        return grid[i - 1][j - 1];
    }


    public boolean isFull(int i, int j) {
        if (i <= 0 || i > len || j <= 0 || j > len) throw new IllegalArgumentException();
        return uf.find(getSiteIndex(i, j)) == uf.find(top);
    }

    public boolean percolates() {
        return uf.find(top) == uf.find(bottom);
    }


    public int numberOfOpenSites() {
        return count;
    }

    private int getSiteIndex(int i, int j) {
        return len * (i - 1) + j;
    }

    public static void main(String[] args) {

    }
}
