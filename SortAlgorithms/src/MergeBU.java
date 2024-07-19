public class MergeBU
{
    private static Comparable[] aux;      // auxiliary array for merges
    // See page 271 for merge() code.
    public static void sort(Comparable[] a) {
        // Do lg N passes of pairwise merges.
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)
            // sz: subarray size
            for (int lo = 0; lo < N - sz; lo += sz + sz) // lo: subarray index
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
    }
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
