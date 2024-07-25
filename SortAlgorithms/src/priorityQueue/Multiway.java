package priorityQueue;

public class Multiway {
    public static void main(String[] args) {
        In[] streams = new In[3];
        streams[0] = new In("src/priorityQueue/1.txt");
        streams[1] = new In("src/priorityQueue/2.txt");
        streams[2] = new In("src/priorityQueue/3.txt");
//        for(int i = 0; i < 6; i++){
//            System.out.println(streams[2].readString());
//        }


        merge(streams);
}

    public static void merge(In[] streams)
    {
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
        for (int i = 0; i < N; i++)
            if (!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        while (!pq.isEmpty())
        {
            System.out.println(pq.min());
            int i = pq.delMin();
            if (!streams[i].isEmpty())
                System.out.println(streams[i] + "*********");
                pq.insert(i, streams[i].readString());

        }

        }

}

