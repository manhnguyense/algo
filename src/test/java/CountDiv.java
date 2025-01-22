import org.junit.jupiter.api.Test;

public class CountDiv {
    /*
    Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.


     */

    @Test
    void test() {
        System.out.println(solution2(0, 0, 11));
    }

    public int solution(int A, int B, int K) {
        int count = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                count++;
            }
        }
        return count;
    }

    public int solution2(int A, int B, int K) {
        // Number of multiples of K up to B
        int countB = B / K;
        // Number of multiples of K up to A-1
        int countA = (A - 1) / K;
        // The difference gives the count of multiples of K in the range [A, B]
        if (A == 0) {
            return countB + 1;
        }
        return countB - countA;
    }
}
