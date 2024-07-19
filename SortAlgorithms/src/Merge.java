public class Merge {
    public static void merge(Comparable[] a, int lo, int mid, int hi) {  // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;
        Comparable[] aux = new Comparable[hi];
        for (int k = lo; k <= hi; k++) {  // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++)  // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
    }
    private static boolean less(Comparable v, Comparable w)
    {  return v.compareTo(w) < 0;  }
}
