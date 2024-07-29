package priorityQueue;

public class Transaction implements Comparable<Transaction>{
    Transaction(String who, Date when, double amount){}
    Transaction(String transaction){}

    String who(){
        return null;
    }
    Date when(){
        return null;
    }
    double amount(){
        return 0.0;
    }
    public String toString(){
        return null;
    }

    public boolean equals(Object that){
        return false;
    }
    public int compareTo(Date that){
        return 0;
    }
    public int hashCode(){
        return 0;
    }

    public int compareTo(Transaction o) {
        return 0;
    }
}

