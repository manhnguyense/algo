package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sort.GsonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseString {

    @Test
    void test() {
        final List<String> input = Arrays.asList("Remote io is awesome", "Best is selected", "I dont know");
        final List<String> expected = Arrays.asList("etomeR oi si emosewa", "tseB si detceles", "I tnod wonk");
        final List<String> reverse = reverse(input);
        System.out.println(GsonUtils.toString(reverse));
        System.out.println(GsonUtils.toString(expected));
        Assertions.assertTrue(expected.get(1).equalsIgnoreCase(reverse.get(1)));
        Assertions.assertTrue(expected.get(2).equalsIgnoreCase(reverse.get(2)));
        Assertions.assertTrue(expected.get(0).equalsIgnoreCase(reverse.get(0)));
    }

    public List<String> reverse(List<String> s) {
        List<String> result = new ArrayList<>();
        for (String string : s) {
            String[] split = string.split(" ");
            StringBuilder val = new StringBuilder();
            for (int i = 0; i < split.length; i++) {
                val.append(new StringBuilder(split[i]).reverse());
                val.append(" ");
            }
            result.add(val.toString().trim());
        }
        return result;
    }
}
