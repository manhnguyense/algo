package coursera.exercise2;

import org.junit.jupiter.api.Test;
import sort.HeapVisualizer;

public class LeastElementsDataStructure {

    @Test
    void test() {
        int[] arr = {9, 5, 15, 2, 4, 6, 1, 3, 0};
        //[0,2,1,3,4,6,15,9,5]
        buildMinHeap(arr);
//        HeapVisualizer.printHeapTree(arr);
        arr = insert(arr, 7);
        //[0,2,1,3,4,6,15,9,5,7]
//        HeapVisualizer.printHeapTree(arr);
        arr = delete(arr, 1);
        HeapVisualizer.printHeapTree(arr);


    }

    private void buildMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            bubbleDown(arr, n, i);
        }
    }

    public int[] delete(int[] heap, int element) {
        int size = heap.length - 1;
        // find in heap
        int i;
        for (i = 0; i <= size; i++) {
            if (element == heap[i]) {
                break;
            }
        }
        //
        heap[i] = heap[size];
        //
        int[] newArr = new int[size - 1];
        for (int j = 0; j < size - 1; j++) {
            newArr[j] = heap[j];
        }
        bubbleDown(newArr, newArr.length, i);
        return newArr;
    }

    int[] insert(int[] arr, int key) {
        int n = arr.length;
        int[] newArr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        newArr[n] = key;
        bubbleUp(newArr, n);
        return newArr;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Use bubble down when deleting the root or any element.
    void bubbleDown(int[] arr, int n, int i) {
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

    //Use bubble up when inserting a new element.
    void bubbleUp(int[] arr, int i) {
        if (i < 2) {
            return;
        }
        int parent = i % 2;
        if (arr[parent] > arr[i]) {
            swap(arr, parent, i);
            bubbleUp(arr, parent);
        }
    }
}
