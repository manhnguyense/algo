package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CycleDetectionV2 {

    @Test
    void test() {
        int n = 3;
        List<List<Integer>> input = Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(1, 2),
            Arrays.asList(2, 0));
        Assertions.assertTrue(hasCycle(n, input));
    }

    public static boolean hasCycle(int numNodes, List<List<Integer>> adj) {
        boolean[] visited = new boolean[numNodes];
        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, -1, adj, visited)) {
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found
    }

    // Helper function for DFS to detect cycles
    private static boolean isCyclicUtil(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, node, adj, visited)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }


}
