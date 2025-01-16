import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinCoinEqualXDynamicPrograming {

    final Integer n = 3;
    final List<Integer> arr = Arrays.asList(1, 3, 5);
    final Integer val = 11;

    @Test
    void testMinCoin() {
        System.out.println("Min: " + minCoinEqualX(n, arr, val));
    }

    private Integer min(Integer a, Integer b) {
        return a <= b ? a : b;
    }

    /*
    arr = [1, 3, 5]
    f(0) = 0;
    f(1) = f0 + 1;
    f(2) = f1 + 1;
    f(3) = min(f2, f0) +1;
    f(4) = f3+1
    LV1:
    Giả sử chúng ta có n đồng xu nặng lần lượt là W1, W2, ..., Wn,
    và bài toán đặt ra là tìm số lượng đồng xu nhỏ nhất để tổng khối lượng của chúng là một giá trị S.
    Tất nhiên, số lượng đồng xu là không giới hạn.
     */
    private Integer minCoinEqualX(final Integer n, final List<Integer> arr, final Integer value) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i < value + 1; i++) {
            for (int x : arr) {
                if (x <= i) {
                    // i-x ==> f0
                    map.put(i, min(map.get(i - 1), map.get(i - x)) + 1);
                }
            }
        }
        System.out.println(map);
        return map.get(value);
    }

    /*
    arr = [1, 3, 5]
    f(0) = 1; // 0
    f(1) = 1; // 1
    f(2) = 1; // 1+1
    f(3) = 2; // 1+1+1 | 3
    f(4) = 3; // 1+1+1+1 | 1+3 |3+1
     Lv2:
     Tìm số cách khác nhau để chọn ra các đồng xu sao cho tổng khối lượng của chúng là S.
     */
    private Integer sumCoinEqualX(final Integer n, final List<Integer> arr, final Integer value) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        System.out.println(map);
        return map.get(value);
    }

    @Test
    void testSumCoin() {
        System.out.println("Sum: " + sumCoinEqualX(n, arr, val));
    }

    private void sumArrIndexEqualX(final List<Integer> arr, final Integer value) {
        int left = 0;
        int right = arr.size() - 1;
        while (left < right) {
            int total = arr.get(left) + arr.get(right);
            if (total == value) {
                System.out.printf("{%s:%s}%n", arr.get(left), arr.get(right));
                left++;
            }
            if (total < value) {
                left++;
            }
            if (total > value) {
                right--;
            }
        }
    }

    @Test
    void testSumArrIndexEqualX() {
        sumArrIndexEqualX(Arrays.asList(3, 5, 6), val);
    }


}
