class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    if (mp.containsKey(i + 1)) {
                        mp.get(i + 1).add(j + 1);
                    } else {
                        mp.put(i + 1, new ArrayList<>());
                        mp.get(i + 1).add(j + 1);
                    }

                    if (mp.containsKey(j + 1)) {
                        mp.get(j + 1).add(i + 1);
                    } else {
                        mp.put(j + 1, new ArrayList<>());
                        mp.get(j + 1).add(i + 1);
                    }
                }
            }
        }

        boolean[] visited = new boolean[isConnected.length + 1];
        int count = 0;
        Queue<Integer> pq = new LinkedList<>();

        for (int i = 1; i <= isConnected.length; i++) {
            if (!visited[i]) {
                count++;

                pq.add(i);
                visited[i] = true;

                while (!pq.isEmpty()) {
                    int n = pq.poll();

                    if (!mp.containsKey(n)) {
                        continue;
                    }

                    for (int j = 0; j < mp.get(n).size(); j++) {
                        int next = mp.get(n).get(j);

                        if (!visited[next]) {
                            pq.add(next);
                            visited[next] = true;
                        }
                    }
                }
            }
        }

        return count;
    }
}