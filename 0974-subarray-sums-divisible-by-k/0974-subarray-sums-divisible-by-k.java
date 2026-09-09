class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int x : nums) {
            sum += x;

            int rem = ((sum % k) + k) % k;

            if (mp.containsKey(rem)) {
                count += mp.get(rem);
            }

            mp.put(rem, mp.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}