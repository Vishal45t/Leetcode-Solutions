class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] res1 = new int[n - 1];
        int[] res2 = new int[n - 1];

        res1[0] = nums[0];
        res1[1] = Math.max(nums[0], nums[1]);

        res2[0] = nums[1];
        res2[1] = Math.max(nums[1], nums[2]);

        for (int i = 2; i < res1.length; i++) {
            res1[i] = Math.max(nums[i] + res1[i - 2], res1[i - 1]);
        }

        for (int i = 2; i < res2.length; i++) {
            res2[i] = Math.max(nums[i + 1] + res2[i - 2], res2[i - 1]);
        }

        return Math.max(res1[n - 2], res2[n - 2]);
    }

}
