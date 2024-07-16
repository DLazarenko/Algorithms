import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // Read strings from standard input, sort them, and print.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = new String[10];
        for(int i = 0; i < a.length; i++){
            try {
                a[i] = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        sort(a);
        assert isSorted(a);
        show(a);
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
