package priorityQueue;

import java.util.Scanner;
import java.util.Stack;

public class TopM {
    public static void main(String[] args) {

        // Print the top M lines in the input stream.
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);

        int M = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>(M + 1);
        while (scanner.hasNext()) {  // Create an entry from the next line and put on the PQ.
            pq.insert(new Transaction(scanner.next()));
            if (pq.size() > M)
                pq.delMin();     // Remove minimum if M+1 entries on the PQ.
        }  // Top M entries are on the PQ.
        Stack<Transaction> stack = new Stack<Transaction>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Transaction t : stack) System.out.println(t);
    }
}
