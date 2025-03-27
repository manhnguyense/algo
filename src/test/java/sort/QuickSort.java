package sort;

import org.junit.jupiter.api.Test;

public class QuickSort {
    @Test
    void test() {
        int[] arr = {9, 5, 15, 2, 0, 4, 1, 3, 6};
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println(GsonUtils.toString(arr));
    }

    void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // all elements from left to i are less than pivot
        // all elements from i + 1 to right are greater than pivot
        swap(arr, i + 1, right);
        return i + 1;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
