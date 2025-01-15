import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Triangle {

    @Test
    void test() {
        final int[] arr = new int[]{10, 2, 5, 1, 8, 20};
        System.out.println(solution(arr));
    }

    public int solution(int[] A) {
        int length = A.length;
        Arrays.sort(A);
        for (int i = 0; i < length - 2; i++) {
            int a = A[i];
            int b = A[i + 1];
            int c = A[i + 2];
            if (isTriangle(a, b, c)) {
                return 1;
            }

        }
        return 0;
    }

    boolean isTriangle(final int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            return true;
        }
        return false;
    }
}
