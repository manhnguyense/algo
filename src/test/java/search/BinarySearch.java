package search;

import org.junit.jupiter.api.Test;

public class BinarySearch {
    @Test
    public void test() {
        int[] arr = {1, 2, 4, 8, 12, 32, 84, 111};
        System.out.println(binarySearch(arr, 0, arr.length - 1, 12));
    }
    /*
    https://colab.research.google.com/drive/1XzD-UqvD0LtSl75XwWCqNnfgHHh5hP0q?usp=sharing
     */

    public boolean binarySearch(int[] arr, int left, int right, int element) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        int val = arr[mid];
        if (element == val) {
            return true;
        }
        if (element < val) {
            right = mid - 1;
            return binarySearch(arr, left, right, element);
        }
        left = mid + 1;
        return binarySearch(arr, left, right, element);
    }
}
