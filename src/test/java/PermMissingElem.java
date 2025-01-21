import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermMissingElem {
    /*
    An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
     */

    @Test
    void test() {
        // sum of positive 1..n S = (n*(n+1))/2
        final int[] arr = new int[]{2, 3, 4, 1, 5, 7};
        System.out.println(solution2(arr));
    }

    public int solution(int[] A) {
        int N = A.length + 1;
        return N * (N + 1) / 2 - Arrays.stream(A).boxed().mapToInt(a -> a).sum();
    }

    public int solution2(int[] A) {
        Set<Integer> s = new HashSet<>();
        int min = 1;
        for (int j : A) {
            s.add(j);
        }
        while (s.contains(min)) {
            min++;
        }
        return min;
    }

}
