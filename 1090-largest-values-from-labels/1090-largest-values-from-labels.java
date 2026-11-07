class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] ar = new int[values.length][2];

        for(int i = 0; i < values.length; i++){
            ar[i][0] = values[i];
            ar[i][1] = labels[i];
        }

        Arrays.sort(ar, (a, b) -> Integer.compare(b[0], a[0]));

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < ar.length; i++){
            int label = ar[i][1];

            if(numWanted > 0 && map.getOrDefault(label, 0) < useLimit){
                sum += ar[i][0];
                numWanted--;

                map.put(label, map.getOrDefault(label, 0) + 1);
            }
        }

        return sum;
    }
}