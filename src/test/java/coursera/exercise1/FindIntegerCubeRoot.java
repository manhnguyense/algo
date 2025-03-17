package coursera.exercise1;

import org.junit.jupiter.api.Test;

public class FindIntegerCubeRoot {

    @Test
    public void test() {
        int n = 1000;
        System.out.println(integerCubeRootHelper(n, 0, n - 1));
    }

    /*
The integer cube root of a positive number 𝑛
is the smallest number  𝑖 such that  𝑖^3≤𝑛 but  (𝑖+1)^3>𝑛 .
For instance, the integer cube root of  100 is  4 since  4^3≤100 but  5^3>100 .
 Likewise, the integer cube root of  1000 is  10 .
Write a function integerCubeRootHelper(n, left, right)
 that searches for the integer cube-root of n between left and right given the following pre-conditions:
𝑛≥1
left<right
left3<𝑛
right3>𝑛
     */

    public int integerCubeRootHelper(double n, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (Math.pow(mid, 3) <= n && (Math.pow(mid + 1, 3) > n)) {
            return mid;
        }
        if (Math.pow(mid, 3) > n) {
            return integerCubeRootHelper(n, left, mid - 1);
        }
        return integerCubeRootHelper(n, mid + 1, right);
    }
}
