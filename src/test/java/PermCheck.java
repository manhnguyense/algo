import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PermCheck {
    /*
    A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.
     */

    @Test
    void test() {
        int[] arr = new int[] {4, 1,2,3};
        System.out.println(solution(arr));

    }
    public int solution(int[] A) {
        int n = A.length;
        int sumToN = (n*(n+1))/2;
        int sum = Arrays.stream(A).boxed().collect(Collectors.toSet())
                .stream().mapToInt(a-> a).sum();
        return sumToN- sum == 0? 1: 0;
    }
}
