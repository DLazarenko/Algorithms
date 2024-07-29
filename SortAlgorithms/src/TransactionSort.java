import java.util.Comparator;

public class TransactionSort {
    public TransactionSort(){

    }
        private final String who = "Ben Smith";
        private final Date when = new Date(20, 12, 2024);
        private final double amount = 100.00;

        public static class WhoOrder implements Comparator<TransactionSort> {
            public int compare(TransactionSort v, TransactionSort w) {
                 return v.who.compareTo(w.who);
            }
        }
        public static class WhenOrder implements Comparator<TransactionSort>
        {
            public int compare(TransactionSort v, TransactionSort w)
            {  return v.when.compareTo(w.when);  }
        }
        public static class HowMuchOrder implements Comparator<TransactionSort>
        {
            public int compare(TransactionSort v, TransactionSort w)
            {
                if (v.amount < w.amount) return -1;
                if (v.amount > w.amount) return +1;
                return 0;
            } }

    public static void main(String[] args) {

    }

}
