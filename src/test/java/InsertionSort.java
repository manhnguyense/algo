import org.junit.jupiter.api.Test;

public class InsertionSort {

    @Test
    void test() {
        int[] arr = {5, 2, 4, 6, 1, 3};
        System.out.println("INIT: " + GsonUtils.toString(arr));
        insertionSortASC(arr);
        System.out.println("SORTED - ASC : " + GsonUtils.toString(arr));

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void insert(int[] arr, int j) {
        for (int i = j - 1; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }

    private void insertionSortASC(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr, i);
        }
    }

}
