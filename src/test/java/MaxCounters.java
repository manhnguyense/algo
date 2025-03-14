import org.junit.jupiter.api.Test;
import sort.GsonUtils;

import java.util.Arrays;

public class MaxCounters {
    /*
    You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.
     */
    @Test
    public void test() {
        int X = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        System.out.println(GsonUtils.toString(solution2(X, A)));
    }

    private void applyMaxCounter(int[] result, int lastUpdate) {
        for (int i = 0; i < result.length; i++) {
            if (result[i] < lastUpdate) {
                result[i] = lastUpdate;
            }
        }
    }

    public int[] solution2(int N, int[] A) {
        int[] result = new int[N];
        int currentMax = 0;
        int lastUpdate = 0;

        for (int i = 0; i < A.length; i++) {
            int index = A[i];
            if (index > N) {
                lastUpdate = currentMax;
            } else {
                if (result[index - 1] < lastUpdate) {
                    result[index - 1] = lastUpdate;
                }
                result[index - 1]++;
                if (result[index - 1] > currentMax) {
                    currentMax = result[index - 1];
                }
            }
        }

        applyMaxCounter(result, lastUpdate);

        return result;
    }

    //Timeout
    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int maxVal = N + 1;
        int max = 0;
        int lastUpdate = 0;
        for (int index : A) {
            if (index == maxVal) {
                if (lastUpdate == 0 || lastUpdate != max) {
                    result = maxCounter2(max, N);
                    lastUpdate = max;
                }
            } else {
                result[index - 1] = result[index - 1] + 1;
                if (result[index - 1] > max) {
                    max = result[index - 1];
                }
            }
        }
        return result;
    }

    private int[] maxCounter2(int maxVal, int N) {
        int[] rs = new int[N];
        Arrays.fill(rs, maxVal);
        return rs;
    }
}
