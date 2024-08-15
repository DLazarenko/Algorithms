import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    Node first;

    private class Node{
        Item item;
        Node next;
    }

    private int size = 0;

    // construct an empty randomized queue
    public RandomizedQueue(){

    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return size() == 0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if(item == null) throw new IllegalArgumentException();
    }

    // remove and return a random item
    public Item dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(isEmpty()) throw new NoSuchElementException();
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{

        private Node element = first;

        public boolean hasNext() {
            return element != null;
        }

        public Item next() {
            if(element == null) throw new NoSuchElementException();
            Item item = element.item;
            element = element.next;

            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    // unit testing (required)
    public static void main(String[] args){

    }

}
