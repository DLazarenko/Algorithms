import java.util.Scanner;

public class LookupCSV {
    public static void main(String[] args) {
        String s = args[0];
        int keyField = Integer.parseInt(args[1]);
        int valField = Integer.parseInt(args[2]);

        ST<String, String> st = new ST<String, String>();
        Scanner scanner = new Scanner(s);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            String key = tokens[keyField];
            String val = tokens[valField];
            st.put(key,val);
        }
    }
}
