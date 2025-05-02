package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CycleDetection {

    private static boolean hasCycle(int numNodes, List<List<Integer>> adj) {
        int[] visited = new int[numNodes];
        for (int i = 0; i < numNodes; i++) {
            if (visited[i] == 0) {
                if (isCyclicUtil(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclicUtil(int node, List<List<Integer>> adj, int[] visited) {
        visited[node] = 1;
        if (adj.get(node) != null) {
            for (int neighbor : adj.get(node)) {
                if (visited[neighbor] == 1) {
                    return true;
                }
                if (visited[neighbor] == 0) {
                    if (isCyclicUtil(neighbor, adj, visited)) {
                        return true;
                    }
                }
            }
        }
        visited[node] = 2;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int numNodes = Integer.parseInt(reader.readLine());
        List<List<Integer>> adj = new ArrayList<>(numNodes);
        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.split("\\s+");
            if (parts.length == 2) {
                try {
                    int fromNode = Integer.parseInt(parts[0]);
                    int toNode = Integer.parseInt(parts[1]);
                    if (fromNode >= 0 && fromNode < numNodes && toNode >= 0 && toNode < numNodes) {
                        adj.get(fromNode).add(toNode);
                    }
                } catch (NumberFormatException e) {
                    break;
                }
            } else {
                break;
            }
        }
        if (hasCycle(numNodes, adj)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
