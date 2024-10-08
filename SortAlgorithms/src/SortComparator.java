import java.util.Comparator;

public class SortComparator {
    public static void main(String[] args) {

    }
    public void sort(Object[] a, Comparator c){
        int N = a.length;
        for(int i = 1; i < N; i++){
            for(int j = i; j > 0 && less(c, a[j], a[j-1]); j--)
                exch(a, j, j - 1);
        }
    }

    private static boolean less(Comparator c, Object v, Object w){
        return c.compare (v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j){
        Object t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
