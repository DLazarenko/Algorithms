public class Quick3way {

/*   Starting with i equal to lo, we process a[i] using the 3-way comparison given us by the
     Comparable interface (instead of using less()) to directly handle the three possible cases:
      ■ a[i] less than v: exchange a[lt] with a[i] and increment both lt and i
      ■ a[i] greater than v: exchange a[i] with a[gt] and decrement gt
      ■ a[i] equal to v: increment       i*/

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt)
        {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else              i++;
        }  // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
