import java.util.Scanner;

public class LookupIndex {
    public static void main(String[] args) {

        String s = args[0];
        Scanner scanner = new Scanner(s);
        String sp = args[1];

        ST<String , Queue<String>> st = new ST<String, Queue<String>>();
        ST<String, Queue<String>> ts = new ST<String, Queue<String>>();

        while(scanner.hasNextLine()){
            String[] a = scanner.nextLine().split(sp);
            String key = a[0];
            for(int i = 1; i < a.length; i++){
                String val = a[i];
                if(!st.contains(key)) st.put(key, new Queue<String>());
                if(!ts.contains(val)) ts.put(val, new Queue<String>());
                st.get(key).enqueue(val);
                ts.get(val).enqueue(key);
            }
        }
        scanner.close();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String query = sc.next();
            if(st.contains(query)){
                for (String l: st.get(query) ) {
                    System.out.println(" " + s);
                }
            }
            if(ts.contains(query))
                for(String l : ts.get(query)){
                    System.out.println(" " + s);
                }
        }
    }
}
