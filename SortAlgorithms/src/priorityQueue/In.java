package priorityQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class In {
   private int counter = 0;
   private String [] arr;
    BufferedReader br = null;
    public In(String filename) {
        try {
        br = new BufferedReader(new FileReader(filename));
        System.out.println("Im here");
        String data = null;

        while ((data = br.readLine()) != null) {
            arr = data.split(" ");
            System.out.println(data);
        }
    } catch (IOException ioe) {
        ioe.printStackTrace();
    } finally {
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}



    public boolean isEmpty() {
        return counter >= arr.length;
    }


    public String readString() {
        if(!isEmpty()){
            System.out.println(counter);
            return arr[counter++];
        }
    return "counter";
    }
}
