package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FindStickEqualTarget {
    @Test
    void test() {
        findStickEqualTarget(Arrays.asList(1, 2, 3, 4, 5), 6);

    }

    void findStickEqualTarget(List<Integer> sticks, int target) {
        sticks.stream().sorted();
        int shortestStick = Integer.MAX_VALUE;
        int shortestStickPair = -1;
        boolean foundPair = false;
        int left = 0;
        int right = sticks.size() - 1;
        while (left < right) {
            int sum = sticks.get(left) + sticks.get(right);
            if (sum == target) {
                foundPair = true;
                if (sticks.get(left) < shortestStick) {
                    shortestStick = sticks.get(left);
                    shortestStickPair = sticks.get(right);
                }
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        if (foundPair) {
            System.out.println("Found pair: " + shortestStick + ", " + shortestStickPair);
        } else {
            System.out.println("No pair found");
        }


    }
}
