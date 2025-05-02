package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueFIFO {
    private static final String OFFER = "OFFER";
    private static final String TAKE = "TAKE";
    private static final String SIZE = "SIZE";

    @Test
    void test() {
        int N = 5;
        int C = 2;
        List<String> actions = Arrays.asList("OFFER hi", "OFFER there", "OFFER !", "TAKE", "SIZE");
        queue(N, C, actions);
    }

    void queue(int N, int C, List<String> actions) {
        Queue<String> queue = new LinkedList<>();
        for (String action : actions) {
            String[] parts = action.split(" ");
            String command = parts[0];
            if (OFFER.equals(command)) {
                String value = parts[1];
                if (queue.size() < C) {
                    queue.offer(value);
                    System.out.println("true");
                } else {
                    System.out.println("Queue is full");
                }
            } else if (TAKE.equals(command)) {
                if (!queue.isEmpty()) {
                    String value = queue.poll();
                    System.out.println(value);
                } else {
                    System.out.println("Queue is empty");
                }
            } else if (SIZE.equals(command)) {
                System.out.println(queue.size());
            }

        }


    }
}
