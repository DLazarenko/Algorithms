public class HeapSortAlgorithm {

    public static void main(String[] args) {
        sort(new int[]{22, 5, 1, 17});
    }

    public static void sort(int[] arr){
        int N = arr.length;
        // 1. Build the heap from the array
        for(int i = N/2-1; i >= 0; i--){
            heapify(arr, N, i);
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " first sort");
        }
        for(int i = N-1; i > 0; i--){
            // 2. Put the largest element at the end of the heap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 3. Cut off last element of the heap and reduce its size by 1
            // 4. Heapify the root element again
            heapify(arr, i, 0);
            // 5. Repeat the process until all the elements are sorted
        }
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }
    public static void heapify(int[] arr, int N, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < N && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < N && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, N, largest);
        }
    }
}
