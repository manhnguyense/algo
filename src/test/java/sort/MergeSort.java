package sort;

import org.junit.jupiter.api.Test;

public class MergeSort {
    @Test
    public void test() {
        int[] arr = {9, 5, 15, 2, 4, 6, 1, 3};
        mergerSort(arr, 0, arr.length - 1);
        System.out.println(GsonUtils.toString(arr));

    }

    private void mergerSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergerSort(arr, p, q);
        mergerSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }

    private int[] merge(int[] arr, int p, int q, int r) {
        int Ln = q - p + 1;
        int Lr = r - q;
        int[] left = new int[Ln];
        int[] right = new int[Lr];
        // insert left
        for (int i = 0; i < Ln; i++) {
            left[i] = arr[p + i];
        }
        // insert right
        for (int i = 0; i < Lr; i++) {
            right[i] = arr[q + i + 1];
        }
        int i = 0;
        int j = 0;
        int k = p;
        while (i < Ln && j < Lr) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < Ln) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < Lr) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return arr;
    }
}
