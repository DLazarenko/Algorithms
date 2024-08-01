import java.io.File;
import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args) throws Exception {
        int minlen = Integer.parseInt(args[0]);  // key-length cutoff
        ST<String, Integer> st = new ST<String, Integer>();
        File file = new File("/src/tale.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String word = scanner.next();
            if(word.length() < minlen) continue;
            if(!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }

        String max = "";
        st.put(max, 0);
        for(String word : st.keys())
            if(st.get(word) > st.get(max)) max = word;
        System.out.println(max + " " + st.get(max));
    }
}
