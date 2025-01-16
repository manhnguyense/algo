import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BinaryGap {
    /*
    A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].

     */

    @Test
    void test1() {
        // https://app.codility.com/programmers/trainings/9/binary_gap/
        System.out.println(findGap(intToBinary(15)));
    }

    public int findGap(String s) {
        String ONE = "1";
        int firstIndex = s.indexOf(ONE);
        int lastIndex = s.lastIndexOf(ONE);
        if (firstIndex == lastIndex) {
            return 0;
        }
        List<Integer> other = other(firstIndex, lastIndex, s);
        System.out.println(other);
        if (other.isEmpty()) {
            return lastIndex - firstIndex - 1;
        }
        return maxIndex(other, firstIndex, lastIndex);
    }

    final int maxIndex(List<Integer> others, int firstIndex, int lastIndex) {
        Set<Integer> s = new TreeSet<>();
        int size = others.size();
        Integer init = others.get(0);
        s.add(init - firstIndex - 1);
        for (int i = 0; i < size; i++) {
            int next = i + 1;
            if (next < size) {
                s.add(others.get(next) - others.get(i) - 1);
            }
        }
        s.add(lastIndex - others.get(size - 1) - 1);
        return s.stream().max(Integer::compareTo).get();
    }

    public List<Integer> other(int firstIndex, int lastIndex, String s) {
        List<Integer> other = new ArrayList<>();
        for (int i = firstIndex + 1; i < lastIndex; i++) {
            if (s.charAt(i) == '1') {
                other.add(i);
            }
        }
        return other;
    }
    
    public String intToBinary(int n) {
        int number = n;
        StringBuilder str = new StringBuilder();
        while (number > 0) {
            str.append(number % 2);
            number = number / 2;
        }
        return str.toString();
    }
}
