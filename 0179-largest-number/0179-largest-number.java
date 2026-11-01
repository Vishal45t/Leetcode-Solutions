class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> nums2 = new ArrayList<>();
        for (int c : nums) {
            nums2.add(c);
        }
        Collections.sort(nums2, (a, b) -> (String.valueOf(b) + String.valueOf(a))
                .compareTo(String.valueOf(a) + String.valueOf(b)));
        String ans = "";

        for (int x : nums2) {
            ans += x;
        }
        if (nums2.get(0) == 0) {
            return "0";
        }
        return ans;
    }
}