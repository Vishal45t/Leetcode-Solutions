class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    if(mp.containsKey(i+1)){
                        mp.get(i+1).add(j+1);
                    }else{
                        mp.put(i+1, new ArrayList<>());
                        mp.get(i+1).add(j+1);
                    }

                    if(mp.containsKey(j+1)){
                        mp.get(j+1).add(i+1);
                    }else{
                        mp.put(j+1, new ArrayList<>());
                        mp.get(j+1).add(i+1);
                    }
                }
            }
        }

        boolean[] visited = new boolean[mp.size()+1];
        Arrays.fill(visited, false);
        int count = 0;
        Queue<Integer> pq = new LinkedList<>();

        for(int i = 0; i < mp.size(); i++){
            if(visited[i+1] == false){
                count++;
            }
            pq.add(i+1);
            visited[i+1] = true;

            while(!pq.isEmpty()){
                int n = pq.poll();

                for(int j = 0; j < mp.get(n).size(); j++){
                    if(!visited[mp.get(n).get(j)]){
                        pq.add(mp.get(n).get(j));
                        visited[mp.get(n).get(j)] = true;
                    }
                }
            }
        }
        return count;
    }
}