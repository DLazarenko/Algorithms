import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            randomizedQueue.enqueue(item);
        }

        Iterator<String> iterator = randomizedQueue.iterator();
        if (k >= 0 && k <= randomizedQueue.size()) {
            int index = 0;
            while (iterator.hasNext() && index < k) {
                StdOut.println(iterator.next());
                index++;
            }
        }
    }
}
