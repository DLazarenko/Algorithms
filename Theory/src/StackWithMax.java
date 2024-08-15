public class StackWithMax {
    private int N;
    private Node first;
    private Node max;

    private class Node {
        private int item;
        private Node next;
    }

    public StackWithMax() {
        N = 0;
        first = null;
        max = null;
    }

    public int getMax() {
        return max.item;
    }

    public void push(int item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
        // if it is first max element - put into max stack
        if(max == null){
            max = new Node();
            max.item = item;
        }
        //if it is not the first element, check if it bigger than already existing max
        else if (item >= getMax()) {
            // if it is bigger - add to the start of the stack
            Node oldmax = max;
            max = new Node();
            max.next = oldmax;
        }else{
            // if not, check the next  and if it is null - put it to the position
            if(max.next == null){
                Node n = new Node();
                n.item = item;
                max.next = n;
            }
        }
        // add to the correct position the value - previous element bigger, next - smaller
            while(max.next != null){
                if(item > max.next.item) {
                    Node temp = max.next;
                    Node node = new Node();
                    node.item = item;
                    max.next = node;
                    node.next = temp;
                }else{
                    max.next = max.next.next;
                }
            }

    }

    public double pop() {
        double tmp = first.item;
        first = first.next;
        N--;
        if (tmp == getMax()) {
            max = max.next;
        }
        return tmp;
    }
}

