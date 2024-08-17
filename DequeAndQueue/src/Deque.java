import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first, last;
    private int size = 0;

    // construct an empty deque
    public Deque() {

    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("item equals null");
        Node node = new Node();
        node.item = item;
        if (size == 0) {
            first = node;
            last = node;
        } else {
            Node oldFirst = first;
            first = node;
            first.next = oldFirst;
            oldFirst.previous = first;
        }
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {

        if (item == null) throw new IllegalArgumentException("item equals null");

        Node node = new Node();
        node.item = item;

        if (size == 0) {
            first = node;
            last = node;
        } else {
            Node oldLast = last;
            last = node;
            oldLast.next = last;
            last.previous = oldLast;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("the deque is empty");
        Item item = first.item;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("the deque is empty");
        Item item = last.item;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (current == null) throw new NoSuchElementException("next equals null");
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("remove method not supported");
        }
    }
    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> d = new Deque<>();
        d.addFirst(50);
        d.addFirst(40);
        d.addLast(20);
        for (Integer integer : d) {
            System.out.println(integer);
        }
    }
}

