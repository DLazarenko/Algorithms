import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ST<String, Integer> st;
        st = new ST<String, Integer>();

            for (int i = 0; scanner.hasNext(); i++) {
                String key = scanner.next();
                if (key.equals(".")) break;
                st.put(key, i);
            }

        for(String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }
}


