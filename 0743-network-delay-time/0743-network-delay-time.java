import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            graph.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        distance[k] = 0;
        priorityQueue.add(new int[] { k, 0 });

        while (!priorityQueue.isEmpty()) {

            int[] current = priorityQueue.poll();

            int destination = current[0];
            int currentDistance = current[1];

            if (currentDistance > distance[destination]) {
                continue;
            }

            for (int[] edge : graph.get(destination)) {

                int nextDestination = edge[0];
                int weight = edge[1];

                int newDistance = distance[destination] + weight;

                if (newDistance < distance[nextDestination]) {

                    distance[nextDestination] = newDistance;

                    priorityQueue.add(
                            new int[] { nextDestination, newDistance });
                }
            }
        }

        int maxDistance = 0;

        for (int i = 1; i <= n; i++) {

            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }

            maxDistance = Math.max(maxDistance, distance[i]);
        }

        return maxDistance;
    }

}
