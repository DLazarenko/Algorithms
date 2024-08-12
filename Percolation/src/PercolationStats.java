import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * The PercolationStats class uses Monte Carlo simulation to estimate the
 * percolation threshold
 *
 * @author Shuai Wang
 */
public class PercolationStats {
    private final int numOfExperiments; // number of experiment carried outs
    private final double[] fractions; // an array storing fraction of each percolation

    /**
     * Perform T independent experiments on an N-by-N grid
     */
    public PercolationStats(int n, int t) {
        if (n <= 0 || t <= 0) {
            throw new IllegalArgumentException("N <= 0 or T <= 0");
        }
        numOfExperiments = t;
        fractions = new double[numOfExperiments];
        for (int expNum = 0; expNum < numOfExperiments; expNum++) {
            Percolation pr = new Percolation(n);
            int openedSite = 0;
            while (!pr.percolates()) {
                int row = StdRandom.uniformInt(1, n + 1);
                int col = StdRandom.uniformInt(1, n + 1);
                if (!pr.isOpen(row, col)) {
                    pr.open(row, col);
                    openedSite++;
                }
            }
            double fraction = (double) openedSite / (n * n);
            fractions[expNum] = fraction;
        }
    }

    public double mean() {
        return StdStats.mean(fractions);
    }


    public double stddev() {
        return StdStats.stddev(fractions);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(numOfExperiments));
    }


    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(numOfExperiments));

    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats pStats = new PercolationStats(N, T);

        String confidence = pStats.confidenceLo() + ", "
                + pStats.confidenceHi();
        StdOut.println("mean                    = " + pStats.mean());
        StdOut.println("stddev                  = " + pStats.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }
}
