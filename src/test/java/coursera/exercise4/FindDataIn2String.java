package coursera.exercise4;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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


    @Test
    void test1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        for (int i = 0; i < n; i++) {
            String line = input.split(" ")[i];
            String[] words = line.split(" ");
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < words.length; j++) {
                StringBuilder reversedWord = new StringBuilder(words[j]).reverse();
                result.append(reversedWord);
                if (j < words.length - 1) {
                    result.append(" ");
                }
            }
            System.out.println(result);
        }

    }

}
