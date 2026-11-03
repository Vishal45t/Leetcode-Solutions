class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> pq = new LinkedList<>();
        int freshCount = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    pq.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        if(pq.isEmpty()){
            return freshCount == 0 ? 0 : -1;
        }

        int num = 0;

        while(!pq.isEmpty()){
            int n = pq.size();
            int count = 0;

            while(count < n){
                int[] ar = pq.poll();
                int i = ar[0];
                int j = ar[1];

                if(i+1 >= 0 && i+1 < grid.length && j >= 0 && j < grid[0].length){
                    if(grid[i+1][j] == 1){
                        grid[i+1][j] = 2;
                        pq.offer(new int[]{i+1, j});
                        freshCount--;
                    }
                }

                if(i-1 >= 0 && i-1 < grid.length && j >= 0 && j < grid[0].length){
                    if(grid[i-1][j] == 1){
                        grid[i-1][j] = 2;
                        pq.offer(new int[]{i-1, j});
                        freshCount--;
                    }
                }

                if(i >= 0 && i < grid.length && j-1 >= 0 && j-1 < grid[0].length){
                    if(grid[i][j-1] == 1){
                        grid[i][j-1] = 2;
                        pq.offer(new int[]{i, j-1});
                        freshCount--;
                    }
                }

                if(i >= 0 && i < grid.length && j+1 >= 0 && j+1 < grid[0].length){
                    if(grid[i][j+1] == 1){
                        grid[i][j+1] = 2;
                        pq.offer(new int[]{i, j+1});
                        freshCount--;
                    }
                }

                count++;
            }

            num++;
        }

        return freshCount == 0 ? num-1 : -1;
    }
}