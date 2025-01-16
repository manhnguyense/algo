import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    Integer n = 6;

    @Test
    void testRecursive() {
        System.out.println(recursive(n));
    }

    private int recursive(int n) {
        if (n < 2) {
            return 1;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    @Test
    void testDynamicPrograming() {
        System.out.println(dynamicPrograming(n));
    }

    private int dynamicPrograming(int n) {
        if (n < 2) {
            return 1;
        }
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        for (int i = 2; i < n + 1; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }
        return map.get(n);
    }
}
