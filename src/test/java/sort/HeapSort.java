package sort;

import org.junit.jupiter.api.Test;

public class HeapSort {

    @Test
    void test() {
        int[] arr = {9, 5, 15, 2, 4, 6, 1, 3, 0};

        int n = arr.length;
        // Build max heap
        buildMaxHeap(arr);
        System.out.println(GsonUtils.toString(arr));
        // Sort with heap
        heapSort(arr, n);

        System.out.println(GsonUtils.toString(arr));

    }

    private void heapSort(int[] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            n = n - 1;
            // call max heapify on the reduced heap
            maxHeapify(arr, n, 0);
        }
    }

    private void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }


    private void maxHeapify(int[] A, int length, int i) {
        // largest is a root
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // if largest < left
        if (left < length && A[left] > A[largest]) {
            largest = left;
        }
        // if largest < right
        if (right < length && A[right] > A[largest]) {
            largest = right;
        }
        // if largest is not root
        if (largest != i) {
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxHeapify(A, length, largest);
        }

    }
}
