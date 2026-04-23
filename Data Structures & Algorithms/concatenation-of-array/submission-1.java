class Solution {
    // *Optimal solution*
    public int[] getConcatenation(int[] nums) {
        int length = nums.length * 2;
        int[] ans = new int[length];

        for (int i = 0; i < ans.length; i++) {
            if (i < nums.length) {
                ans[i] = nums[i];
            }
            else ans[i] = nums[i - nums.length];
        }

        return ans;
    }
}
