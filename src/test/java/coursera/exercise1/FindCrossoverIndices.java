package coursera.exercise1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FindCrossoverIndices {
    /*
    Problem 1: Find Crossover Indices.
You are given data that consists of points (𝑥0,𝑦0),…,(𝑥𝑛,𝑦𝑛)
, wherein 𝑥0<𝑥1<…<𝑥𝑛
, and 𝑦0<𝑦1…<𝑦𝑛
 as well.

Furthermore, it is given that 𝑦0<𝑥0
 and 𝑦𝑛>𝑥𝑛
.

Find a "cross-over" index 𝑖
 between 0
 and 𝑛−1
 such that 𝑦𝑖≤𝑥𝑖
 and 𝑦𝑖+1>𝑥𝑖+1
.

Note that such an index must always exist (convince yourself of this fact before we proceed).

Example

𝑖𝑥𝑖𝑦𝑖00−2120242354467578681071012

Your algorithm must find the index 𝑖=3
 as the crossover point.

On the other hand, consider the data

𝑖𝑥𝑖𝑦𝑖00−2111.5242354467578681071012

We have two cross over points. Your algorithm may output either 𝑖=0
 or 𝑖=3
.

(A) Design an algorithm to find an index  𝑖∈{0,1,…,𝑛−1}
  such that  𝑥𝑖≥𝑦𝑖
  but  𝑥𝑖+1<𝑦𝑖+1
 .

Describe your algorithm using python code for a function findCrossoverIndexHelper(x, y, left, right)

x is a list of x values sorted in increasing order.
y is a list of y values sorted in increasing order.
x and y are lists of same size (n).
left and right are indices that represent the current search region in the list such that 0 <= left < right <= n
Your solution must use recursion.

Hint: Modify the binary search algorithm we presented in class.
     */

    @Test
    void test() {
        double[] x = {0, 1, 2, 3, 4, 5, 6, 7};
        double[] y = {-2, 0, 4, 5, 6, 7, 8, 9};
        System.out.println(findCrossoverIndexHelper(x, y, 0, x.length - 1));
    }

    @Test
    void test2() {
        double[] x = {0, 1, 4, 5, 6, 7, 8, 10};
        double[] y = {-2, 1.5, 2, 4, 7, 8, 10, 12};
        System.out.println(findCrossoverIndex(x, y));
    }

    public int findCrossoverIndexHelper(double[] x, double[] y, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (y[mid] <= x[mid] && y[mid + 1] >= x[mid + 1]) {
            return mid;
        }
        if (y[mid] > x[mid]) {
            return findCrossoverIndexHelper(x, y, left, mid);
        }
        return findCrossoverIndexHelper(x, y, mid + 1, right);
    }

    public List<Integer> findCrossoverIndex(double[] x, double[] y) {
        List<Integer> result = new ArrayList<>();
        int n = x.length - 1;
        int index = findCrossoverIndexHelper(x, y, 0, n);
        while (index != -1) {
            result.add(index);
            index = findCrossoverIndexHelper(x, y, 0, index - 1);
        }
        return result;
    }
}
