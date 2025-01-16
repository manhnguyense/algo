import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TwoSumInArrayEqualX {
    @Test
    void test() {
        int arr[] = {1, 2, 3, 7, 9, 6, 10};
        int sum = 16;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer val = sum - arr[i];
            if (map.containsKey(val)) {
                System.out.println(String.format("{%s:%s}", arr[i], val));
            }
            map.put(arr[i], i);
        }

    }

    @Test
    void test2() {
        int arr[] = {1, 2, 3, 6, 7, 9, 10};
        int sum = 16;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            final int total = arr[left] + arr[right];
            if (total == sum) {
                System.out.printf("{%s:%s}%n", arr[left], arr[right]);
                left++;
            } else if (total < sum) {
                left++;
            } else {
                right--;
            }
        }
    }

    @Test
    void test3() {
        int arr[] = {1, 2, 3, 6, 7, 9, 10};
        int sum = 16;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                final int total = arr[i] + arr[left] + arr[right];
                if (total == sum) {
                    System.out.printf("{%s:%s:%s}%n", arr[i], arr[left], arr[right]);
                    left++;
                } else if (total < sum) {
                    left++;
                } else {
                    right--;
                }

            }
        }
    }
}
