import org.assertj.core.util.Maps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

    public static Map<Character, Integer> dijkstra(Map<Character, Map<Character, Integer>> graph, char start) {
        Map<Character, Integer> distances = new HashMap<>();
        for (char node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            char u = current.node;
            int distU = current.distance;

            if (distU > distances.get(u)) {
                continue;
            }

            if (graph.containsKey(u)) {
                for (Map.Entry<Character, Integer> neighborEntry : graph.get(u).entrySet()) {
                    char v = neighborEntry.getKey();
                    int weightUV = neighborEntry.getValue();
                    int distV = distU + weightUV;

                    if (distV < distances.get(v)) {
                        distances.put(v, distV);
                        pq.offer(new Node(v, distV));
                    }
                }
            }
        }

        return distances;
    }

    private static class Node {
        char node;
        int distance;

        public Node(char node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Map<Character, Map<Character, Integer>> graph = new HashMap<>();
        Map<Character, Integer> BC = Maps.newHashMap('B', 2);
        BC.put('C', 3);
        graph.put('A', BC);
        Map<Character, Integer> DE = Maps.newHashMap('D', 4);
        DE.put('E', 1);
        graph.put('B', DE);
        graph.put('C', Maps.newHashMap('E', 5));
        graph.put('D', Maps.newHashMap('F', 2));
        graph.put('E', Maps.newHashMap('F', 2));
        graph.put('F', new HashMap<>());

        char startNode = 'A';
        Map<Character, Integer> shortestPaths = dijkstra(graph, startNode);

        System.out.println("Shortest paths from " + startNode + ":");
        for (Map.Entry<Character, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("To " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
