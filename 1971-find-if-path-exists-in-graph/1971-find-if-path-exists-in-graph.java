class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int[] ar : edges) {
            int n1 = ar[0];
            int n2 = ar[1];

            if (mp.containsKey(n1)) {
                mp.get(n1).add(n2);
            } else {
                mp.put(n1, new ArrayList<>());
                mp.get(n1).add(n2);
            }

            if (mp.containsKey(n2)) {
                mp.get(n2).add(n1);
            } else {
                mp.put(n2, new ArrayList<>());
                mp.get(n2).add(n1);
            }
        }

        Queue<Integer> pq = new LinkedList<>();
        boolean[] visited = new boolean[n];

        pq.add(source);
        visited[source] = true;

        while (!pq.isEmpty()) {
            int n1 = pq.poll();

            if (n1 == destination) {
                return true;
            }

            if (!mp.containsKey(n1)) {
                continue;
            }

            for (int i = 0; i < mp.get(n1).size(); i++) {
                int next = mp.get(n1).get(i);

                if (!visited[next]) {
                    pq.add(next);
                    visited[next] = true;
                }
            }
        }

        return false;
    }
}