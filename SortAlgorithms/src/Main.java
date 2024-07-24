import priorityQueue.In;

public class Main {
    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] a = new String[10];
//        for(int i = 0; i < a.length; i++){
//            try {
//                a[i] = br.readLine();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        sort(a);
//        assert isSorted(a);
//        show(a);
        In in = new In(".priorityQueue/1.txt");
        System.out.println(in.readString());
        System.out.println(in.readString());
        Comparable[] a = new Comparable[16];
        a[0] = "K";
        a[1] = "R";
        a[2] = "A";
        a[3] = "T";
        a[4] = "E";
        a[5] = "L";
        a[6] = "E";
        a[7] = "P";
        a[8] = "U";
        a[9] = "I";
        a[10] = "M";
        a[11] = "Q";
        a[12] = "C";
        a[13] = "X";
        a[14] = "O";
        a[15] = "S";

        System.out.println(partition(a, 0, 15));
    }
    private static int partition(Comparable[] a, int lo, int hi) {
        System.out.println("started");
        // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi + 1;            // left and right scan indices
        Comparable v = a[lo];            // partitioning item
        while (true) {
            // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            System.out.println(a[i] + " and " + a[j]);
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j;  // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }
    public static void sort(Comparable[] a)
    {  /* See Algorithms 2.1, 2.2, 2.3, 2.4, 2.5, or 2.7. */  }
    private static boolean less(Comparable v, Comparable w)
    {  return v.compareTo(w) < 0;  }
    private static void exch(Comparable[] a, int i, int j)
    {  Comparable t = a[i]; a[i] = a[j]; a[j] = t;  }
    private static void show(Comparable[] a)
    {  // Print the array, on a single line.
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a)
    {  // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))  return false;
        return true;
    }
}
