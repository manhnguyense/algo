package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestFindNumber {


    @Test
    void test() {
        int[] arr = new int[]{112, 124, 152, 134, 143, 268};
        Map<Integer, Integer> result = countSmallerElements(arr);
        System.out.println(result);
    }

    public static Map<Integer, Integer> countSmallerElements(int[] arr) {
        // Coordinate compression to handle large numbers
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < sortedArr.length; i++) {
            rankMap.put(sortedArr[i], i + 1);
        }

        // Fenwick Tree for counting
        int[] fenwickTree = new int[arr.length + 1];
        Map<Integer, Integer> result = new LinkedHashMap<>();

        for (int num : arr) {
            int rank = rankMap.get(num);
            result.put(num, queryFenwickTree(fenwickTree, rank - 1));
            updateFenwickTree(fenwickTree, rank, 1);
        }

        return result;
    }

    private static void updateFenwickTree(int[] fenwickTree, int index, int value) {
        while (index < fenwickTree.length) {
            fenwickTree[index] += value;
            index += index & -index;
        }
    }

    private static int queryFenwickTree(int[] fenwickTree, int index) {
        int sum = 0;
        while (index > 0) {
            sum += fenwickTree[index];
            index -= index & -index;
        }
        return sum;
    }
}
