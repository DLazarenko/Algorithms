import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int size = 0;
    private Item[] array = (Item[]) new Object[10];


    // construct an empty randomized queue
    public RandomizedQueue() {

    }

    // unit testing (required)
    public static void main(String[] args) {

        RandomizedQueue<Integer> queue = new RandomizedQueue<>();

        queue.enqueue(11);
        queue.dequeue();
        queue.enqueue(33);
        queue.enqueue(43);


//        for (int a : queue) {
//            StdOut.print(a);
//            StdOut.println();
//        }
        StdOut.println(queue.dequeue() + " - dequeue");
        StdOut.println(queue.size() + " - size");
        StdOut.println(queue.sample() + " - sample");
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (array.length == size) {
            Item[] newArray = (Item[]) new Object[size * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = item;
        size++;

    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item;
        if (size() == 1) {
            item = array[0];
            array[0] = null;
            size = 0;
        } else {
            int randomItem = StdRandom.uniformInt(size);
            item = array[randomItem];
            if (!(randomItem == size - 1)) {
                array[randomItem] = array[size - 1];
            }
            size--;
            array[size] = null;
        }
        if (size < array.length / 4 && size > 1) {
            Item[] newArray = (Item[]) new Object[size / 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        return array[StdRandom.uniformInt(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Item[] iArr;
        private int index;

        public ListIterator() {
            iArr = array.clone();
            StdRandom.shuffle(iArr, 0, size);
        }


        public boolean hasNext() {
            return index < size;
        }

        public Item next() {
            if (hasNext()) return iArr[index++];
            else throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
}
