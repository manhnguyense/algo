package sort;

public class MinHeap {

    public static void main(String[] args) {
        int[] arr = {9, 5, 15, 2, 4, 6, 1, 3, 0};
        buildMinHeap(arr);
        HeapVisualizer.printHeapTree(arr);
        System.out.println(GsonUtils.toString(arr));
    }

    public static void buildMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            bubbleDown(arr, n, i);
        }
    }

    public static void bubbleDown(int[] arr, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(arr, i, smallest);
            bubbleDown(arr, n, smallest);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
