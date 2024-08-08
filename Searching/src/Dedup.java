import java.util.HashSet;
import java.util.Scanner;

public class Dedup {
    public static void main(String[] args) {
        HashSet<String> set;
        set = new HashSet<String>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String key = scanner.next();
            if(!set.contains(key)){
                set.add(key);
                System.out.println(key);
            }
        }
    }
}
