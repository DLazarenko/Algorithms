public class HeapSortAlgorithm {

    public static void main(String[] args) {
        sort(new int[]{1,12,9,5,6,10});
    }

    public static void sort(int[] arr){
        int N = arr.length;
        for(int i = N/2-1; i >= 0; i--){
            heapify(arr, N, i);
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
