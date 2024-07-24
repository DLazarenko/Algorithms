package priorityQueue;

public class IndexMinPQ<Item extends Comparable<Item>>{

    private int N;
    private int[] pq;
    private int[] qp;
    private Item[] items;


        // create a priority queue of capacity maxN with possible indices between 0 and maxN-1
        public IndexMinPQ(int maxN){
            items = (Item[]) new Comparable[maxN + 1];
            pq = new int[maxN + 1];
            qp = new int[maxN + 1];
            for (int i = 0; i <= maxN; i++){
                qp[i] = -1;
            }
        }

        // is the priority queue empty?
        public boolean isEmpty(){
            return N == 0;
        }

        // is k associated with some item?
        public boolean contains(int k){
            return qp[k] != -1;
        }

        // insert item; associate it with k
        void insert(int k, Item item){
            N++;
            qp[k] = N;
            pq[N] = k;
            items[k] = item;
            swim(N);
        }

        // change the item associated with k to item
        void change(int k, Item item) {}



        // remove k and its associated item
        void delete(int k){}

        // return a minimal item
        public Item min(){
            return items[pq[1]];
        }

        // return a minimal item’s index
        int minIndex(){
            return 0;
        }

        // remove a minimal item and return its index
        int delMin() {
            int indexOfMin = pq[1];
            exch(1, N--);
            sink(1);
            items[pq[N+1]] = null;
            qp[pq[N+1]] = -1;
            return indexOfMin;
        }


        // number of items in the priority queue
        int size(){
            return 0;
        }
    private static boolean less(Comparable v, Comparable w)
    {  return v.compareTo(w) < 0;  }

    private void exch(int i, int j) {
        int t = pq[i]; pq[i] = pq[j]; pq[j] = t;
    }
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }
    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
 }
