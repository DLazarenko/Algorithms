package priorityQueueSite;

 /*  % more m1.txt
 *  A B C F G I I Z
 *
 *  % more m2.txt
 *  B D H P Q Q
 *
 *  % more m3.txt
 *  A B E F J N
 *
 *  % java Multiway m1.txt m2.txt m3.txt
 *  A A B B B C D E F F G H I I J N P Q Q Z
 *
 ******************************************************************************/

import priorityQueue.In;

/**
 *  The {@code Multiway} class provides a client for reading in several
 *  sorted text files and merging them together into a single sorted
 *  text stream.
 *  This implementation uses a {@link IndexMinPQ} to perform the multiway
 *  merge.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/24pq">Section 2.4</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class Multiway {

    // This class should not be instantiated.
    private Multiway() { }

    // merge together the sorted input streams and write the sorted result to standard output
    private static void merge(In[] streams) {
        int n = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(n);
        for (int i = 0; i < n; i++) {
    System.out.println("streams.length = " + pq.size());
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }
        // Extract and print min and read next from its stream.
        while (!pq.isEmpty()) {
            System.out.print(pq.minKey() + " ");
            int i = pq.delMin();
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int n = args.length;
        In[] streams = new In[n];
        for (int i = 0; i < n; i++)
            streams[i] = new In(args[i]);
        merge(streams);
    }
}

