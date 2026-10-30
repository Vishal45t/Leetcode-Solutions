import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Create adjacency matrix
        int[][] adj = new int[n + 1][n + 1];
        for (int[] row : adj) {
            Arrays.fill(row, -1);
        }

        for (int[] edge : times) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];

            adj[source][destination] = weight;
        }

        // PriorityQueue: {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]);

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[k] = 0;
        pq.add(new int[] { 0, k });

        // Dijkstra's Algorithm
        while (!pq.isEmpty()) {

            int[] m = pq.poll();

            int weight = m[0];
            int src = m[1];

            if (weight > distance[src]) {
                continue;
            }

            for (int i = 1; i <= n; i++) {

                if (adj[src][i] != -1) {

                    int newDistance = distance[src] + adj[src][i];

                    if (newDistance < distance[i]) {

                        distance[i] = newDistance;

                        pq.add(new int[] { newDistance, i });
                    }
                }
            }
        }

        // Find maximum distance
        int max = 0;

        for (int i = 1; i <= n; i++) {

            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, distance[i]);
        }

        return max;
    }
}