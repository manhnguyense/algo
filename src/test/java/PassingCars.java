import org.junit.jupiter.api.Test;

public class PassingCars {
    /*

    A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

For example, consider array A such that:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
     */
    @Test
    public void test() {
        int[] A = {0, 1, 0, 1, 1};
        System.out.println(solution(A));
    }

    public int solution(int[] A) {
        int countEasts = 0;
        int passingCars = 0;
        for (int x : A) {
            if (x == 0) {
                countEasts++;
            } else if (x == 1) {
                passingCars += countEasts;
            }
            if (passingCars > 1000000000) {
                return -1;
            }
        }
        return passingCars;

    }
}
