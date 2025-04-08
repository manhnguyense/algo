package coursera.exercise4;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class FindDataIn2String {

    @Test
    void test() {
        String S1 = "GATATATACAGACAATAGATAGACACACGTAGGTGCACAGT";
        String S2 = "AGGATTTAGGTGGAACCCAGAGAGTTTAGGACCAGATTAGAT";
        System.out.println(findDataIn2String(S1, S2, 5));
    }

    public String findDataIn2String(String s1, String s2, int length) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < s1.length() - length; i++) {
            String sub = s1.substring(i, i + length);
            result.add(sub);
        }
        for (int i = 0; i < s2.length() - length; i++) {
            String sub = s2.substring(i, i + length);
            if (result.contains(sub)) {
                return sub;
            }
        }

        return "";
    }


}
