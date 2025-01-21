import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    /*
    Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.
     */

    @Test
    public void test() {
        int[] A = {1};
        System.out.println(solution(A));
    }

    public int solution(int[] A) {
        Set<Integer> positiveNumbers = new HashSet<>();

        // Add all positive numbers from the array into the set
        for (int num : A) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        // Find the smallest positive integer that is not in the set
        int smallestMissingPositive = 1;
        while (positiveNumbers.contains(smallestMissingPositive)) {
            smallestMissingPositive++;
        }

        return smallestMissingPositive;
    }
}
